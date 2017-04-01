public class NthDigit {
    public int findNthDigit(int n) {
        int acc = 0;
        int width = 1;
        int count = 9;
        while ((n - acc) / width > count) {
            acc += count * width;
            count *= 10;
            width++;
        }
        int start = 1;
        for (int i = 1; i < width; i++) {
            start *= 10;
        }
        int end = (n - acc) / width - 1 + start;
        int k = (n - acc) % width;
        if (k == 0) return end % 10;
        end++;
        int digit = 0;
        for (int i = 0; i < k; i++) {
            digit = end / start;
            end -= start * digit;
            start /= 10;
        }
        return digit;
    }
}

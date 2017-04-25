public class NthDigit {
    public int findNthDigit(int n) {
        int acc = 0, width = 1, start = 1, count = 9;
        while ((n - acc) / width > count) {
            acc += count * width;
            count *= 10;
            start *= 10;
            width++;
        }
        start += (n - acc - 1) / width;
        return (start + "").charAt((n - acc - 1) % width) - '0';
    }
}

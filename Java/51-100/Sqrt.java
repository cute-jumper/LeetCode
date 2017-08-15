public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int low = 1;
        int high = x;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int quo = x / mid;
            if (mid == quo) return mid;
            else if (mid < quo) low = mid;
            else high = mid - 1;
        }
        return low;
    }
}

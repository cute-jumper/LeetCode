public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        if (x < 4) return 1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int r = (low + high) / 2;
            long diff = ((long)r) * r - x;
            if (diff == 0) {
                return r;
            } else if (diff > 0) {
                high = r - 1;
            } else {
                low = r + 1;
            }
        }
        return high * high > x ? high - 1 : high;
    }
}

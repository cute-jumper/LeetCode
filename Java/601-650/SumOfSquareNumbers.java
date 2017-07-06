public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i * i <= c / 2; i++) {
            int j = c - i * i;
            int r = (int)Math.sqrt(j);
            if (r * r == j) return true;
        }
        return false;
    }
}

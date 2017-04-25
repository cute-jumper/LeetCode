public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0;
        int total = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                total += ++curr;
            } else {
                curr = 0;
            }
        }
        return total;
    }
}

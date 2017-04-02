public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int low = 0;
        int total = 0;
        while (low < A.length - 2) {
            if (A[low + 1] - A[low] == A[low + 2] - A[low + 1]) {
                int diff = A[low + 1] - A[low];
                for (int i = low + 3; i <= A.length; i++) {
                    if (i == A.length || A[i] - A[i - 1] != diff) {
                        total += (i - low - 1) * (i - low - 2) / 2;
                        low = i - 1;
                        break;
                    }
                }
            } else {
                low++;
            }
        }
        return total;
    }
}

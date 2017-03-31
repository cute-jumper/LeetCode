public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int base = 0;
        for (int i = 0 ; i < A.length; i++) {
            sum += A[i];
            base += i * A[i];
        }
        int maxVal = base;
        for (int i = A.length - 1; i > 0; i--) {
            base += sum - A.length * A[i];
            maxVal = Math.max(maxVal, base);
        }
        return maxVal;
    }
}

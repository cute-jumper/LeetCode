public class ContiguousSubarraySum402 {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A.length == 0) return res;
        int[] lens = new int[A.length], dp = new int[A.length];
        dp[0] = A[0];
        lens[0] = 0;
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + A[i];
                lens[i] = lens[i - 1] + 1;
            } else {
                dp[i] = A[i];
                lens[i] = 0;
            }
            if (dp[maxIndex] < dp[i]) maxIndex = i;
        }
        res.add(maxIndex - lens[maxIndex]);
        res.add(maxIndex);
        return res;
    }
}

public class LongestIncreasingSubseq397 {
    /*
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A.length < 2) return A.length;
        int max = 1, cnt1 = 1, cnt2 = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                cnt1++;
                cnt2 = 1;
            } else {
                cnt1 = 1;
                cnt2++;
            }
            max = Math.max(max, Math.max(cnt1, cnt2));
        }
        return max;
    }
}

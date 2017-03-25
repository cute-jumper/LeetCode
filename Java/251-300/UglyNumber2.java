public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[index1] * 2,
                                      dp[index2] * 3),
                             dp[index3] * 5);
            if (dp[i] == dp[index1] * 2) index1++;
            if (dp[i] == dp[index2] * 3) index2++;
            if (dp[i] == dp[index3] * 5) index3++;
        }
        return dp[n - 1];
    }
}

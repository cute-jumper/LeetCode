public class StudentAttendanceRecord2 {
    public int checkRecord(int n) {
        if (n == 1) return 3;
        long mod = 1000000000l + 7;
        long[][] dp = new long[n][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
            dp[i][1] = dp[i-1][0];
            dp[i][2] = dp[i-1][1];
        }
        long res = dp[n-1][0] + dp[n-1][1] + dp[n-1][2];
        res %= mod;
        for (int i = 0; i < n; i++) {
            res += (i > 0 ? (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod : 1) * (i < n - 1 ? (dp[n-2-i][0] + dp[n-2-i][1] + dp[n-2-i][2]) % mod : 1);
            res %= mod;
        }
        return (int) (res % mod);
    }
}

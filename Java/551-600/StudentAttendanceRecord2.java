public class StudentAttendanceRecord2 {
    public class Solution {
        public int checkRecord(int n) {
            if (n == 1) return 3;
            long mod = 1000000000l + 7;
            long[] dp = new long[n];
            dp[0] = 2;
            for (int i = 1; i < n; i++) {
                dp[i] = (dp[i-1] + (i > 1 ? dp[i-2] : 1) + (i > 2 ? dp[i-3] : 1)) % mod;
            }
            long res = dp[n-1];
            for (int i = 0; i < n; i++) {
                res += ((i > 0 ? dp[i-1] : 1) * (i < n -1 ? dp[n-2-i] : 1)) % mod;
                res %= mod;
            }
            return (int)res;
        }
    }
}

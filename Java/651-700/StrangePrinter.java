class Solution {
    public int strangePrinter(String s) {
        if (s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                int e = j + i;
                dp[j][e] = dp[j][e - 1] + 1;
                for (int k = j; k < e; k++) {
                    if (s.charAt(k) == s.charAt(e)) {
                        dp[j][e] = Math.min(dp[j][e], dp[j][k] + dp[k + 1][e - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

public class LongestPalindromicSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i + len <= s.length(); i++) {
                int end = i + len - 1;
                dp[i][end] = Math.max(dp[i + 1][end], dp[i][end - 1]);
                if (s.charAt(i) == s.charAt(end)) {
                    dp[i][end] = Math.max(dp[i][end],
                                          2 + (len > 2 ? dp[i + 1][end - 1] : 0));
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

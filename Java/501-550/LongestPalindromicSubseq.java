public class LongestPalindromicSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s.isEmpty()) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) dp[i][i] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = Math.max(dp[j][j + i], 2 + (i == 1 ? 0 : dp[j + 1][j + i - 1]));
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}

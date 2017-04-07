public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int len = 1; len <= s3.length(); len++) {
            for (int i = 0; i <= len && i <= s1.length(); i++) {
                int j = len - i;
                if (j > s2.length()) continue;
                if (i > 0 && s1.charAt(i-1) == s3.charAt(len-1)) {
                    dp[i][j] = dp[i-1][j];
                }
                if (j > 0 && s2.charAt(j-1) == s3.charAt(len-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

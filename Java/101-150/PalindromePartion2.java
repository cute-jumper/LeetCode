public class PalindromePartion2 {
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = i - 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j]);
            }
            for (int j = 1; j <= i + 1 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j + 1]);
            }
        }
        return dp[s.length()];
    }
}

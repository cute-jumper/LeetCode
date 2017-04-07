public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            int diag = dp[0];
            dp[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                int tmp = dp[j];
                dp[j] = Math.min(dp[j - 1], dp[j]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = Math.min(diag, dp[j]);
                } else {
                    dp[j] = Math.min(diag + 1, dp[j]);
                }
                diag = tmp;
            }
        }
        return dp[word2.length()];
    }
}

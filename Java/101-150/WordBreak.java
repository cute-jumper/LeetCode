public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String word = s.substring(j, i);
                if (dp[j] && inWordDict(wordDict, word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean inWordDict(List<String> wordDict, String word) {
        for (String s : wordDict) {
            if (s.equals(word)) return true;
        }
        return false;
    }
}

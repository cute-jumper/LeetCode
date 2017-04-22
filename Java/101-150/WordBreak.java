public class WordBreak {
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     Set<String> wordSet = new HashSet<>();
    //     for (String word : wordDict) wordSet.add(word);
    //     return checkWordBreak(new int[s.length()], s, 0, wordSet);
    // }
    // public boolean checkWordBreak(int[] memo, String s, int start, Set<String> wordSet) {
    //     if (start == s.length()) return true;
    //     if (memo[start] != 0) return memo[start] == 1;
    //     for (int i = s.length(); i > start; i--) {
    //         String sub = s.substring(start, i);
    //         if (wordSet.contains(sub)) {
    //             if (checkWordBreak(memo, s, i, wordSet))
    //                 return (memo[start] = 1) == 1;
    //         }
    //     }
    //     return (memo[start] = -1) == 1;
    // }
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

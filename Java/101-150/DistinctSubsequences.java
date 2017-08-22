public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < t.length(); i++) {
            int prev = dp[i], curr = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    curr += prev;
                }
                prev = dp[j + 1];
                dp[j + 1] = curr;
            }
        }
        return dp[s.length()];
        // if (s.length() < t.length()) return 0;
        // int[][] dp = new int[t.length() + 1][s.length() + 1];
        // Arrays.fill(dp[0], 1);
        // for (int i = 0; i < t.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         dp[i + 1][j + 1] = dp[i + 1][j];
        //         if (t.charAt(i) == s.charAt(j)) dp[i + 1][j + 1] += dp[i][j];
        //     }
        // }
        // return dp[t.length()][s.length()];
    }
}

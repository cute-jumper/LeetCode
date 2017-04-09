public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        if (t.length() == 0) return 1;
        int[] dp = new int[s.length()];
        int current = 0;
        char c = t.charAt(0);
        for (int i = 0; i < dp.length; i++) {
            if (s.charAt(i) == c) {
                current++;
            }
            dp[i] = current;
        }
        for (int i = 1; i < t.length(); i++) {
            c = t.charAt(i);
            current = 0;
            int prev = dp[i - 1];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    current += prev;
                }
                prev = dp[j];
                dp[j] = current;
            }
        }
        return dp[s.length() - 1];
    }
}

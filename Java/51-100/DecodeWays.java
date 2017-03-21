public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char before = s.charAt(i - 1);
            char current = s.charAt(i);
            if (before == '1' || before == '2' && current <= '6') {
                dp[i + 1] = dp[i - 1];
            }
            if (current != '0') {
                dp[i + 1] += dp[i];
            }
        }
        return dp[s.length()];
    }
}

public class EncodeStringWithShortestLength {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = "" + s.charAt(i);
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = getEncoding(s, i, j, dp);
                for (int k = i; k < j; k++) {
                    String encoded = dp[i][k] + dp[k+1][j];
                    if (encoded.length() < dp[i][j].length()) dp[i][j] = encoded;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
    private String getPattern(String s) {
        int index = (s + s).indexOf(s, 1);
        return s.substring(0, index);
    }
    private String getEncoding(String s, int i, int j, String[][] dp) {
        String sub = s.substring(i, j + 1);
        String p = getPattern(sub);
        int count = sub.length() / p.length();
        if (count == 1) return sub;
        String encoded = count + "[" + dp[i][i + p.length() - 1] + "]";
        if (encoded.length() < sub.length()) return encoded;
        return sub;
    }
}

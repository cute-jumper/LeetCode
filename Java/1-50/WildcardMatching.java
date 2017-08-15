public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1));
                }
            }
        }
        return dp[s.length()][p.length()];
        // int sIndex = 0;
        // int pIndex = 0;
        // int aIndex = -1;
        // int mIndex = -1;
        // while (sIndex < s.length()) {
        //     if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
        //         pIndex++;
        //         sIndex++;
        //     } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
        //         aIndex = pIndex;
        //         mIndex = sIndex;
        //         pIndex++;
        //     } else {
        //         if (aIndex == -1) return false;
        //         pIndex = aIndex + 1;
        //         sIndex = ++mIndex;
        //     }
        // }
        // while (pIndex < p.length()) {
        //     if (p.charAt(pIndex) != '*') return false;
        //     pIndex++;
        // }
        // return true;
    }
}

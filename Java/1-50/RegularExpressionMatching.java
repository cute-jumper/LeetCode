public class Solution {
    public boolean isMatch(String s, String p) {
        int[][] memo = new int[s.length() + 1][p.length()];
        return isMatch(memo, s, p, 0, 0);
    }
    private boolean isMatch(int[][] memo, String s, String p, int ss, int ps) {
       	if (ps == p.length()) return ss == s.length();
        if (memo[ss][ps] != 0) return memo[ss][ps] == 1;
        if (ps < p.length() - 1 && p.charAt(ps + 1) == '*') {
            boolean match = isMatch(memo, s, p, ss, ps + 2);
            if (!match && ss < s.length() && (p.charAt(ps) == '.' || p.charAt(ps) == s.charAt(ss))) {
                match = isMatch(memo, s, p, ss + 1, ps + 2) || isMatch(memo, s, p, ss + 1, ps);
            }
            memo[ss][ps] = match ? 1 : -1;
            return match;
        }
        if (ss < s.length() && (p.charAt(ps) == '.' || p.charAt(ps) == s.charAt(ss))) {
            boolean match = isMatch(memo, s, p, ss + 1, ps + 1);
            memo[ss][ps] = match ? 1 : -1;
            return match;
        }
        memo[ss][ps] = -1;
        return false;
    }
    // boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
    // match[0][0] = true;
    // for (int i = 1; i <= p.length(); i++) match[0][i] = i > 1 && match[0][i - 2] && p.charAt(i - 1) == '*';
    // for (int i = 0; i < s.length(); i++) {
    //     char c1 = s.charAt(i);
    //     for (int j = 0; j < p.length(); j++) {
    //         char c2 = p.charAt(j);
    //         if (c2 == '*') {
    //             match[i + 1][j + 1] = match[i + 1][j - 1] || match[i][j + 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == c1);
    //         } else {
    //             match[i + 1][j + 1] = (c2 == '.' || c1 == c2) && match[i][j];
    //         }
    //     }
    // }
    // return match[s.length()][p.length()];
}

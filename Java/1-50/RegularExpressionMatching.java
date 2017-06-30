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
}

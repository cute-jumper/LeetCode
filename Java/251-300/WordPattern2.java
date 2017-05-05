public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(new String[256], new HashMap<>(), pattern, 0, str, 0);
    }
    public boolean dfs(String[] p2s, Map<String, Character> s2p, String pattern, int pstart, String str, int sstart) {
        if (pstart == pattern.length() && sstart == str.length()) return true;
        if (pstart == pattern.length() || sstart == str.length()) return false;
        char p = pattern.charAt(pstart);
        if (p2s[p] != null) {
            String match = p2s[p];
            if (str.startsWith(match, sstart)) {
                return dfs(p2s, s2p, pattern, pstart + 1, str, sstart + match.length());
            } else {
                return false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = sstart; i < str.length(); i++) {
            sb.append(str.charAt(i));
            String s = sb.toString();
            if (!s2p.containsKey(s)) {
                p2s[p] = s;
                s2p.put(s, p);
                boolean success = dfs(p2s, s2p, pattern, pstart + 1, str, i + 1);
                p2s[p] = null;
                s2p.remove(s);
                if (success) return true;
            }
        }
        return false;
    }
}

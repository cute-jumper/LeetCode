public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        if (t.length() - s.length() > 1) return false;
        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (diff++ == 1) return false;
                }
            }
            return diff == 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(i).equals(t.substring(i + 1));
        }
        return true;
    }
}

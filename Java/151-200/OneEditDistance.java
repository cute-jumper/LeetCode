public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                int j = t.length() == s.length() ? i + 1 : i;
                return s.substring(j).equals(t.substring(i + 1));
            }
        }
        return s.length() != t.length();
    }
}

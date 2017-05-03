public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() < t.length()) return isOneEditDistance(t, s);
        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) diff++;
            }
            return diff == 1;
        }
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (tIndex < i - 1) return false;
            if (tIndex < t.length() && s.charAt(i) == t.charAt(tIndex)) tIndex++;
        }
        return tIndex == t.length();
    }
}

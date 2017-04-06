public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) {
            if (p.charAt(0) == '.') return s.length() == 1;
            return s.length() == 1 && s.charAt(0) == p.charAt(0);
        }
        if (p.charAt(1) == '*') {
            boolean match = isMatch(s, p.substring(2));
            int index = 0;
            while (!match && index < s.length() &&
                   (s.charAt(index) == p.charAt(0) || p.charAt(0) == '.')) {
                match = isMatch(s.substring(index + 1), p.substring(2));
                index++;
            }
            return match;
        } else {
            if (s.length() < 1) return false;
            return (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) &&
                isMatch(s.substring(1), p.substring(1));
        }
    }
}

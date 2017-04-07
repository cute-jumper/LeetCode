public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        int index = readExp(s, 0);
        return index == s.length();
    }
    public int readSign(String s, int start) {
        if (start >= s.length()) return start;
        if (s.charAt(start) == '-' || s.charAt(start) == '+') return start + 1;
        return start;
    }
    public int readInt(String s, int start) {
        if (start >= s.length()) return start;
        int index = start;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                index++;
            } else {
                return index;
            }
        }
        return s.length();
    }
    public int readDecimal(String s, int start) {
        if (start >= s.length()) return start;
        int index = readInt(s, start);
        if (index == s.length() || s.charAt(index) != '.') return index;
        boolean first = index != start;
        index++;
        int secondStart = index;
        index = readInt(s, secondStart);
        boolean second = index != secondStart;
        return (first || second) ? index : start;
    }
    public int readExp(String s, int start) {
        if (start >= s.length()) return start;
        int firstStart = readSign(s, start);
        int index = readDecimal(s, firstStart);
        if (index == firstStart) return start;
        if (index == s.length() || s.charAt(index) != 'e') return index;
        index++;
        int secondStart = readSign(s, index);
        index = readInt(s, secondStart);
        return index != secondStart ? index : start;
    }
}

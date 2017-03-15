public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char first = needle.charAt(0);
        int start = 0;
        while (start < haystack.length() - needle.length() + 1) {
            if (haystack.charAt(start) == first && strEqual(haystack, start, needle)) {
                return start;
            }
            start++;
        }
        return -1;
    }
    public boolean strEqual(String large, int start, String small) {
        if (start + small.length() > large.length()) return false;
        for (int i = 0; i < small.length(); i++) {
            if (small.charAt(i) != large.charAt(start + i))
                return false;
        }
        return true;
    }
}

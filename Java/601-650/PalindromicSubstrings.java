public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += maxLen(s, i, true) + maxLen(s, i, false);
        }
        return c;
    }
    int maxLen(String s, int index, boolean flag) {
        int i = flag ? index - 1 : index;
        int j = 2 * index - i + (flag ? 0 : 1);
        for (; i >= 0 && j< s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        return index - i;
    }
}

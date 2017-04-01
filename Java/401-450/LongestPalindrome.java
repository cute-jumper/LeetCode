public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            } else {
                count[26 + c - 'A']++;
            }
        }
        int len = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 2) {
                len += (count[i] & ~1);
                count[i] %= 2;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) return len + 1;
        }
        return len;
    }
}

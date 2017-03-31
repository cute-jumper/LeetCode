public class LongestSubStringWithKRepeat {
    public int longestSubstring(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int low = 0;
        int maxLen = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || count[s.charAt(i) - 'a'] < k) {
                if (i > low) {
                    if (i - low == s.length()) return s.length();
                    int len = longestSubstring(s.substring(low, i), k);
                    if (len > maxLen) maxLen = len;
                }
                low = i + 1;
            }
        }
        return maxLen;
    }
}

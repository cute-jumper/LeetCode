public class LongestSubStringWithKRepeat {
    public int longestSubstring(String s, int k) {
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        int low = 0, max = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || count[s.charAt(i)] < k) {
                if (i > low) {
                    if (i - low == s.length()) return s.length();
                    max = Math.max(max, longestSubstring(s.substring(low, i), k));
                }
                low = i + 1;
            }
        }
        return max;
    }
}

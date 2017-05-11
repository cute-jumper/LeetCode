public class LongestSubstringWithAtMostTwo {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int cnt = 0;
        int low = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) cnt++;
            while (cnt == 3) {
                if (count[s.charAt(low++)]-- == 1) cnt--;
            }
            maxLen = Math.max(maxLen, i - low + 1);
        }
        return maxLen;
    }
}

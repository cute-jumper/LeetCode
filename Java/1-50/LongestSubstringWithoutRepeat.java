public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[256];
        int longest = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            j = Math.max(index[c], j);
            index[c] = i + 1;
            longest = Math.max(i - j + 1, longest);
        }
        return longest;
    }
}

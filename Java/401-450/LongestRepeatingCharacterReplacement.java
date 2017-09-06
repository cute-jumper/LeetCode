public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0, start = 0;
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++count[s.charAt(i)]);
            if (max + k == i - start) count[s.charAt(start++)]--;
        }
        return s.length() - start;
    }
}

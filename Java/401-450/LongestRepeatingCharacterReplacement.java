public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int low = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (++count[s.charAt(i) - 'A'] > max)
                max = count[s.charAt(i) - 'A'];
            if (max + k <= i - low) count[s.charAt(low++) - 'A']--;
        }
        return s.length() - low;
    }
}

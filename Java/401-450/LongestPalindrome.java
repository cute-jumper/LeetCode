public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        int res = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (count[c]++ == 1) {
                res += 2;
                one--;
            }
            else one++;
            count[c] %= 2;
        }
        return res + (one > 0 ? 1 : 0);
    }
}

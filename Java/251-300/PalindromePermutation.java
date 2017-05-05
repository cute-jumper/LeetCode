public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 1 && cnt++ == 1) return false;
        }
        return true;
    }
}

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int maxLen = 0;
        for (int i = s.length() / 2; i >= 0; i--) {
            if (isPalindrome(s, i, i + 1)) {
                maxLen = i * 2 + 2;
                break;
            }
            if (isPalindrome(s, i, i)) {
                maxLen = i * 2 + 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= maxLen; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
    public boolean isPalindrome(String s, int mid1, int mid2) {
        while (mid1 >= 0 && mid2 < s.length() && s.charAt(mid1) == s.charAt(mid2)) {
            mid1--;
            mid2++;
        }
        return mid1 == -1;
    }
}

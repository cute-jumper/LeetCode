public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high) {
                if (Character.isLetterOrDigit(s.charAt(low))) break;
                else low++;
            }
            while (low < high) {
                if (Character.isLetterOrDigit(s.charAt(high))) break;
                else high--;
            }
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}

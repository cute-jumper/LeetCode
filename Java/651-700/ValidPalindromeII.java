class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) return true;
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) break;
            low++;
            high--;
        }
        if (low >= high) return true;
        return isValid(s, low + 1, high) || isValid(s, low, high - 1);
    }
    boolean isValid(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}

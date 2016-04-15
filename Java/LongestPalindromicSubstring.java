public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i - 1; j <= i; ++j) {
                int len = lengthOfLongestPalindrome(s, j, i);
                if (len > maxLength) {
                    maxLength = len;
                    startIndex = i - len / 2;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public int lengthOfLongestPalindrome(String s, int low, int high) {
        if (low < 0 || high >= s.length()) {
            return 0;
        }
        while (low >= 0 && high < s.length() &&
               s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        return high - low - 1;
    }
}

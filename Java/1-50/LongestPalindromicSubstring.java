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
    // dp
    /*
    public class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            int max = 0;
            int start = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i +  1][j - 1]);
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                    }
                }
            }
            return s.substring(start, start + max);
        }
    }
    */
}

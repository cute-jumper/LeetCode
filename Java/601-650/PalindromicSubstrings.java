public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += getCount(s, i, 0) + getCount(s, i, -1);
        }
        return count;
    }
    int getCount(String s, int index, int offset) {
        int left = index + offset;
        int right = index + 1;
        for (; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
        }
        return (right - left) / 2;
    }
}

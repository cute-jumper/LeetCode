public class Lswrc {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0, end = 1, len = 1;
        int[] posArray = new int[256];
        for (int i = 0; i < posArray.length; i++) {
            posArray[i] = -1;
        }
        posArray[s.charAt(start)] = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (posArray[c] != -1) {
                int currLength = end - start;
                if (currLength > len) {
                    len = currLength;
                }
                int newStart = posArray[c] + 1;
                for (int i = start; i < newStart; i++) {
                    posArray[s.charAt(i)] = -1;
                }
                start = newStart;
            }
            posArray[c] = end++;
        }
        int currLength = end - start;
        if (currLength > len) {
            len = currLength;
        }
        return len;
    }
}

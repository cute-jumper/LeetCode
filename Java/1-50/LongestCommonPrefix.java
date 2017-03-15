public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (strs[0].length() == i) return sb.toString();
            char c = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (i == strs[j].length()) {
                    return sb.toString();
                } else if (strs[j].charAt(i) != c) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(c);
            } else {
                break;
            }
            i++;
        }
        return sb.toString();
    }
}

public class ReverseWordsInString {
    public String reverseWords(String s) {
        int index = s.length() - 1;
        int start = -1;
        int end = -1;
        StringBuilder sb = new StringBuilder();
        while (index >= -1) {
            if (index == -1 || s.charAt(index) == ' ') {
                if (start <= end && start >= 0) {
                    for (int i = start; i <= end; i++) {
                        sb.append(s.charAt(i));
                    }
                    sb.append(' ');
                    start = -1;
                    end = -1;
                }
            } else {
                if (end == -1) end = index;
                start = index;
            }
            index--;
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

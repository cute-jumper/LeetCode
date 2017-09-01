public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, end = s.length() - 1; i >= -1; i--) {
            if (i == -1 || s.charAt(i) == ' ') {
                if (end > i && sb.length() != 0) sb.append(' ');
                for (int j = i + 1; j <= end; j++) sb.append(s.charAt(j));
                end = i - 1;
            }
        }
        return sb.toString();
    }
}

public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder wb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') wb.append(c);
            else {
                sb.append(wb.reverse().toString());
                sb.append(c);
                wb.delete(0, wb.length());
            }
        }
        sb.append(wb.reverse().toString());
        return sb.toString();
    }
}

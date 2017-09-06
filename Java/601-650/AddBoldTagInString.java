public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        boolean[] flag = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String w : dict) {
                if (s.startsWith(w, i)) end = Math.max(end, i + w.length());
            }
            flag[i] = end > i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i] && (i == 0 || !flag[i - 1])) sb.append("<b>");
            sb.append(s.charAt(i));
            if (flag[i] && (i == s.length() - 1 || !flag[i + 1])) sb.append("</b>");
        }
        return sb.toString();
    }
}

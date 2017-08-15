public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0, len = 0; i < words.length; i += j) {
            for (j = 0, len = 0; i + j < words.length && len + words[i + j].length() + j <= maxWidth; j++) {
                len += words[i + j].length();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            for (int k = 1; k < j; k++) {
                if (i + j >= words.length) sb.append(' ');
                else {
                    int space = (maxWidth - len) / (j - 1);
                    if (k <= (maxWidth - len) % (j - 1)) space++;
                    sb.append(makeString(' ', space));
                }
                sb.append(words[i + k]);
            }
            sb.append(makeString(' ', maxWidth - sb.length()));
            res.add(sb.toString());
        }
        return res;
    }
    String makeString(char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) sb.append(c);
        return sb.toString();
    }
}

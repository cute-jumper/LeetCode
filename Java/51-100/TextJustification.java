public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = 0;
        List<String> current = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int k = 0; k < words.length; k++) {
            if (len + words[k].length() + current.size() > maxWidth) {
                int spaces = maxWidth - len;
                StringBuilder sb = new StringBuilder();
                sb.append(current.get(0));
                if (current.size() == 1) {
                    for (int i = sb.length(); i < maxWidth; i++) sb.append(' ');
                } else {
                    int eachSpace = spaces / (current.size() - 1);
                    int added = spaces % (current.size() - 1);
                    for (int i = 1; i < current.size(); i++) {
                        for (int j = 0; j < eachSpace; j++) {
                            sb.append(' ');
                        }
                        if (i <= added) sb.append(' ');
                        sb.append(current.get(i));
                    }
                }
                res.add(sb.toString());
                current.clear();
                current.add(words[k]);
                len = words[k].length();
            } else {
                len += words[k].length();
                current.add(words[k]);
            }
        }
        if (current.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(current.get(0));
            for (int i = 1; i < current.size(); i++) {
                sb.append(' ');
                sb.append(current.get(i));
            }
            for (int i = sb.length(); i < maxWidth; i++) sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}

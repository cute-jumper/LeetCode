public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(dict);
        String[] ps = sentence.split(" ");
        for (int i = 0; i < ps.length; i++) {
            String s = ps[i];
            String prefix = null;
            for (int j = 0; j < dict.size(); j++) {
                String t = dict.get(j);
                if (s.startsWith(t)) {
                    prefix = t;
                    break;
                }
            }
            sb.append(prefix == null ? s : prefix);
            if (i != ps.length - 1) sb.append(' ');
        }
        return sb.toString();
    }
}

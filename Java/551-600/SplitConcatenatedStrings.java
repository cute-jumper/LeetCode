public class SplitConcatenatedStrings {
    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String r = new StringBuilder(strs[i]).reverse().toString();
            if (r.compareTo(strs[i]) > 0) {
                strs[i] = r;
            }
        }
        String max = null;
        for (int i = 0; i < strs.length; i++) {
            String rest = remove(strs, i);
            String s = strs[i];
            String r = new StringBuilder(s).reverse().toString();
            for (int j = 0; j < s.length(); j++) {
                String cand1 = s.substring(j) + rest + s.substring(0, j);
                String cand2 = r.substring(j) + rest + r.substring(0, j);
                String cand;
                if (cand1.compareTo(cand2) > 0) {
                    cand = cand1;
                } else {
                    cand = cand2;
                }
                if (max == null || cand.compareTo(max) > 0) max = cand;
            }
        }
        return max;
    }
    String remove(String[] strs, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = r + 1; i < strs.length; i++) sb.append(strs[i]);
        for (int i = 0; i < r; i++) sb.append(strs[i]);
        return sb.toString();
    }
}

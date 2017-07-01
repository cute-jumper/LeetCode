public class SubstringWithConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (map.containsKey(w)) {
                map.put(w, map.get(w) + 1);
            } else {
                map.put(w, 1);
            }
        }
        int wl = words[0].length();
        int totalLen = wl * words.length;
        for (int i = 0; i < wl; i++) {
            Map<String, Integer> m = new HashMap<>(map);
            int count = words.length;
            for (int j = i, k = 0; j + wl <= s.length(); j += wl, k++) {
                String str = s.substring(j, j + wl);
                if (m.containsKey(str)) {
                    m.put(str, m.get(str) - 1);
                    if (m.get(str) >= 0) count--;
                }
                if (k >= words.length) {
                    str = s.substring(j - totalLen, j - totalLen + wl);
                    if (m.containsKey(str)) {
                        m.put(str, m.get(str) + 1);
                        if (m.get(str) > 0) count++;
                    }
                }
                if (count == 0) res.add(j - totalLen + wl);
            }
        }
        return res;
    }
}

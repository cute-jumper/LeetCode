public class SubstringWithConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) return res;
        Map<String, Integer> dict = new HashMap<>();
        for (String w : words) {
            if (dict.containsKey(w)) dict.put(w, dict.get(w) + 1);
            else dict.put(w, 1);
        }
        for (int start = 0; start < wordLen && start + totalLen <= s.length(); start++) {
            Map<String, Integer> map = new HashMap<>(dict);
            int count = 0;
            for (int i = start; i < start + totalLen; i += wordLen) {
                String w = s.substring(i, i + wordLen);
                if (map.containsKey(w)) {
                    map.put(w, map.get(w) - 1);
                    if (map.get(w) == 0) count++;
                    else if (map.get(w) == -1) count--;
                }
            }
            if (count == dict.size()) res.add(start);
            for (int i = start + wordLen; i + totalLen <= s.length(); i += wordLen) {
                String w = s.substring(i - wordLen, i);
                if (dict.containsKey(w)) {
                    map.put(w, map.get(w) + 1);
                    if (map.get(w) == 0) count++;
                    else if (map.get(w) == 1) count--;
                }
                w = s.substring(i + totalLen - wordLen, i + totalLen);
                if (map.containsKey(w)) {
                    map.put(w, map.get(w) - 1);
                    if (map.get(w) == 0) count++;
                    else if (map.get(w) == -1) count--;
                }
                if (count == dict.size()) res.add(i);
            }
        }
        return res;
    }
}

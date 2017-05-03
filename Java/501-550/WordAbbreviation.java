public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dict.size(); i++) {
            String s = dict.get(i);
            String abbr = getAbbr(s, 1);
            if (!map.containsKey(abbr)) map.put(abbr, new ArrayList<>());
            map.get(abbr).add(i);
            res.add("");
        }
        boolean found = true;
        while (found) {
            found = false;
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                if (entry.getValue().size() > 1) {
                    found = true;
                    separate(dict, map, entry.getKey());
                    break;
                }
            }
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            res.set(entry.getValue().get(0), entry.getKey());
        }
        return res;
    }
    private void separate(List<String> dict, Map<String, List<Integer>> map, String key) {
        List<Integer> idx = map.get(key);
        String first = dict.get(idx.get(0));
        int prefix = 0;
        for (int i = 0; i < first.length() && prefix == 0; i++) {
            boolean diff = false;
            char c = first.charAt(i);
            for (int j = 1; j < idx.size(); j++) {
                if (dict.get(idx.get(j)).charAt(i) != c) {
                    diff = true;
                    prefix = i + 1;
                    break;
                }
            }
        }
        for (int i : idx) {
            String abbr = getAbbr(dict.get(i), prefix);
            if (!map.containsKey(abbr)) map.put(abbr, new ArrayList<>());
            map.get(abbr).add(i);
        }
        map.remove(key);
    }
    private String getAbbr(String s, int prefix) {
        if (prefix + 2 >= s.length()) return s;
        return s.substring(0, prefix) + (s.length() - prefix - 1) + s.charAt(s.length() - 1);
    }
}

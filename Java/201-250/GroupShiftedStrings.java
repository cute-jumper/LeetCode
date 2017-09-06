public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String k = convert(s);
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(s);
        }
        res.addAll(map.values());
        return res;
    }
    String convert(String s) {
        char c = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) sb.append((char)((s.charAt(i) - c + 26) % 26 + 'a'));
        return sb.toString();
    }
}

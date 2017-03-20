public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if (anagramMap.containsKey(key)) {
                anagramMap.get(key).add(s);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(s);
                anagramMap.put(key, anagramList);
            }
        }
        return new ArrayList<List<String>>(anagramMap.values());
    }
}

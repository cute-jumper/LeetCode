public class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) add(s);
    }
    private void add(String s) {
        String abbr = getAbbr(s);
        if (!map.containsKey(abbr)) map.put(abbr, new HashSet<>());
        map.get(abbr).add(s);
    }
    private String getAbbr(String s) {
        if (s.length() < 3) return s;
        else return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }
    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !(map.containsKey(abbr) && (!map.get(abbr).contains(word) || map.get(abbr).size() > 1));
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */

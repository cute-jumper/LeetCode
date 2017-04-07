public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int start = 0, end = 0;
        int count = 0;
        String res = s;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count++;
            }
            while (start < s.length() && count == map.size()) {
                c = s.charAt(start++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    count--;
                }
                if (end - start + 2 < res.length()) {
                    res = s.substring(start - 1, end + 1);
                }
            }
            end++;
        }
        return res;
    }
}

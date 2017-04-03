public class SortCharByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        String[] count = new String[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (count[entry.getValue()] == null)
                count[entry.getValue()] = "" + entry.getKey();
            else
                count[entry.getValue()] += entry.getKey();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = count.length - 1; i > 0; i--) {
            if (count[i] != null) {
                for (int j = 0; j < count[i].length(); j++) {
                    for (int k = 0; k < i; k++) {
                        sb.append(count[i].charAt(j));
                    }
                }
            }
        }
        return sb.toString();
    }
}

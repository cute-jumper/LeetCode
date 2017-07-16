public class AutocompleteSystem {
    class Item implements Comparable<Item> {
        String s;
        int freq;
        Item(String s, int freq) {
            this.s = s;
            this.freq = freq;
        }
        public int compareTo(Item o) {
            if (o.freq != freq) return o.freq - freq;
            return s.compareTo(o.s);
        }
    }
    List<Item> ss = new ArrayList<>();
    Map<String, Item> map = new HashMap<>();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < times.length; i++) {
            Item it = new Item(sentences[i], times[i]);
            ss.add(it);
            map.put(sentences[i], it);
        }
        Collections.sort(ss);
    }
    String curr = "";
    public List<String> input(char c) {
        List<Item> temp = new ArrayList<>();
        if (c == '#') {
            if (map.containsKey(curr)) {
                map.get(curr).freq++;
            } else {
                Item it = new Item(curr, 1);
                map.put(curr, it);
                ss.add(it);
            }
            Collections.sort(ss);
            curr = "";
            return new ArrayList<>();
        }
        curr += c;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < ss.size() && res.size() < 3; i++) {
            String s = ss.get(i).s;
            if (s.startsWith(curr)) res.add(s);
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

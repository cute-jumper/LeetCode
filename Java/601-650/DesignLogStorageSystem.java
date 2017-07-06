public class LogSystem {
    class Item implements Comparable<Item> {
        String ts;
        int id;
        Item(int id, String ts) {
            this.id = id;
            this.ts = ts;
        }
        public int compareTo(Item o) {
            if (!ts.equals(o.ts)) return ts.compareTo(o.ts);
            return id - o.id;
        }
    }
    TreeSet<Item> set = new TreeSet<>();
    Map<String, Integer> map = new HashMap<>();

    public String getStr(String s, String gra, boolean upper) {
        int end = map.get(gra);
        StringBuilder sb = new StringBuilder(s.substring(0, end));
        for (int i = end; i < 19; i++) {
            if (s.charAt(i) == ':') sb.append(':');
            else sb.append(upper ? '9' : '0');
        }
        return sb.toString();
    }

    public LogSystem() {
        map.put("Second", 19);
        map.put("Minute", 16);
        map.put("Hour", 13);
        map.put("Day", 10);
        map.put("Month", 7);
        map.put("Year", 4);
    }

    public void put(int id, String timestamp) {
        set.add(new Item(id, timestamp));
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        Item low = new Item(-1, getStr(s, gra, false));
        Item high = new Item(Integer.MAX_VALUE, getStr(e, gra, true));
        Set<Item> sub = set.subSet(low, true, high, true);
        List<Integer> res = new ArrayList<>();
        for (Item i : sub) res.add(i.id);
        return res;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */

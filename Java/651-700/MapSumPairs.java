class MapSum {
    Map<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int s = 0;
        for (String st : map.keySet()) {
            if (st.startsWith(prefix)) s += map.get(st);
        }
        return s;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

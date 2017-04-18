/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        if (!set.add(val) || map1.containsKey(val) || map2.containsKey(val)) return;
        boolean added = false;
        if (map2.containsKey(val - 1)) {
            int low = map2.get(val - 1);
            map1.put(low, val);
            map2.put(val, low);
            map2.remove(val - 1);
            added = true;
        }
        if (map1.containsKey(val + 1)) {
            int high = map1.get(val + 1);
            if (map2.containsKey(val)) {
                int low = map2.get(val);
                map1.put(low, high);
                map2.put(high, low);
            } else {
                map1.put(val, high);
                map2.put(high, val);
            }
            map1.remove(val + 1);
            added = true;
        }
        if (!added) {
            map1.put(val, val);
            map2.put(val, val);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            res.add(new Interval(entry.getKey(), entry.getValue()));
        }
        Collections.sort(res, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

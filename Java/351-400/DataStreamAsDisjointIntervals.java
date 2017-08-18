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

    Map<Integer, Integer> map;
    Set<Integer> set;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new HashMap<>();
        set = new HashSet<>();
    }

    public void addNum(int val) {
        if (set.add(val)) {
            int left = map.containsKey(val - 1) ? map.get(val - 1) : 0;
            int right = map.containsKey(val + 1) ? map.get(val + 1) : 0;
            int len = left + 1 + right;
            map.put(val - left, len);
            map.put(val + right, len);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList<>();
        if (set.size() == 0) return res;
        List<Integer> keys = new ArrayList<>(set);
        Collections.sort(keys);
        int nextAllowed = 0;
        for (Integer i : keys) {
            if (i >= nextAllowed) {
                res.add(new Interval(i, i + map.get(i) - 1));
                nextAllowed = i + map.get(i) + 1;
            }
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

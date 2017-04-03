/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> startMap = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            startMap.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < res.length; i++) {
            Integer key = startMap.ceilingKey(intervals[i].end);
            if (key == null) res[i] = -1;
            else res[i] = startMap.get(key);
        }
        return res;
    }
}

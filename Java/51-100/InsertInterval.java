/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start, end = newInterval.end;
        for (Interval i : intervals) {
            if (i.start >= start && i.start <= end || start >= i.start && start <= i.end) {
                start = Math.min(start, i.start);
                end = Math.max(end, i.end);
            }
        }
        List<Interval> res = new ArrayList<>();
        int index = 0;
        while (index < intervals.size()) {
            Interval i = intervals.get(index);
            if (i.start > start) break;
            if (i.end < start) res.add(i);
            index++;
        }
        res.add(new Interval(start, end));
        while (index < intervals.size()) {
            Interval i = intervals.get(index);
            if (i.start > end) res.add(i);
            index++;
        }
        return res;
    }
}

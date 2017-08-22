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
        List<Interval> res = new ArrayList<>();
        int index = 0;
        for (; index < intervals.size() && intervals.get(index).end < newInterval.start; index++) {
            res.add(intervals.get(index));
        }
        if (index < intervals.size()) newInterval.start = Math.min(newInterval.start, intervals.get(index).start);
        for (; index < intervals.size() && intervals.get(index).start <= newInterval.end; index++) {
            newInterval.end = Math.max(newInterval.end, intervals.get(index).end);
        }
        res.add(newInterval);
        for (; index < intervals.size(); index++) {
            res.add(intervals.get(index));
        }
        return res;
    }
}

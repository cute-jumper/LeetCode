/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval a, Interval b) {
                    if (a.end < b.end) return -1;
                    if (a.end > b.end) return 1;
                    return 0;
                }
            });
        int count = 1;
        Interval current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < current.end) {
                continue;
            } else {
                current = intervals[i];
                count++;
            }
        }
        return intervals.length - count;
    }
}

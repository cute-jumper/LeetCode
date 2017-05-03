/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length < 2) return intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<>(10, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(interval);
        }
        return pq.size();
    }
}

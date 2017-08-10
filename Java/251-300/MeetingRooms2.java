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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval it : intervals) {
            if (!pq.isEmpty() && pq.peek() <= it.start) pq.poll();
            pq.offer(it.end);
        }
        return pq.size();
    }
}

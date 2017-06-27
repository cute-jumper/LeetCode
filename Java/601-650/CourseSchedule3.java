public class CourseSchedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(courses.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        int len = 0, count = courses.length;
        for (int[] c : courses) {
            len += c[0];
            pq.add(c);
            while (len > c[1]) {
                len -= pq.poll()[0];
                count--;
            }
        }
        return count;
    }
}

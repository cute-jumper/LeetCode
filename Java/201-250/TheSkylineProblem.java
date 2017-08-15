public class TheSkylineProblem {
    static class Point implements Comparable<Point> {
        int x;
        int h;
        boolean left;
        Point(int x, int h, boolean left) {
            this.x = x;
            this.h = h;
            this.left = left;
        }
        @Override
        public int compareTo(Point o) {
            if (x != o.x) return x - o.x;
            return getH() - o.getH();
        }
        private int getH() {
            return left ? -h : h;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        Point[] ps = new Point[buildings.length * 2];
        int index = 0;
        for (int[] b : buildings) {
            ps[index++] = new Point(b[0], b[2], true);
            ps[index++] = new Point(b[1], b[2], false);
        }
        Arrays.sort(ps);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<int[]> res = new ArrayList<>();
        pq.offer(0);
        int prev = 0;
        for (Point p : ps) {
            if (p.left) {
                pq.offer(-p.h);
            } else {
                pq.remove(-p.h);
            }
            int highest = -pq.peek();
            if (highest != prev) {
                res.add(new int[] { p.x, highest });
                prev = highest;
            }
        }
        return res;
    }
}

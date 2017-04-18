public class TheSkylineProblem {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        Point prev;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean isEnd() {
            return prev != null;
        }
        @Override
        public int compareTo(Point that) {
            if (x < that.x) return -1;
            if (x > that.x) return 1;
            if (prev != null && that.prev != null) {
                if (y < that.y) return -1;
                if (y > that.y) return 1;
                return 0;
            }
            if (prev != null) return 1;
            if (that.prev != null) return -1;
            if (y > that.y) return -1;
            if (y < that.y) return 1;
            return 0;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        Point[] ps = new Point[buildings.length * 2];
        int index = 0;
        for (int[] b : buildings) {
            ps[index] = new Point(b[0], b[2]);
            index++;
            ps[index] = new Point(b[1], b[2]);
            ps[index].prev = ps[index - 1];
            index++;
        }
        Arrays.sort(ps);
        PriorityQueue<Point> pq = new PriorityQueue<>(ps.length, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.y < b.y) return 1;
                if (a.y > b.y) return -1;
                return 0;
            }
        });
        for (Point p : ps) {
            if (p.isEnd()) {
                pq.remove(p.prev);
                if (pq.isEmpty()) {
                    res.add(new int[] { p.x, 0 });
                } else if (pq.peek().y != res.get(res.size() - 1)[1]) {
                    res.add(new int[] { p.x, pq.peek().y });
                }
            } else {
                if ((pq.isEmpty() || p.y > pq.peek().y)) {
                    res.add(new int[] { p.x, p.y });
                }
                pq.add(p);
            }
        }
        return res;
    }
}
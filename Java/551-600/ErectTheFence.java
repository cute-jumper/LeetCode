/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class ErectTheFence {
    public List<Point> outerTrees(Point[] points) {
        List<Point> res = new ArrayList<>();
        if (points.length == 0) return res;
        Point left = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < left.x) left = points[i];
        }
        Point curr = left;
        Set<Point> set = new HashSet<>();
        set.add(curr);
        Point next = null;
        while (true) {
            for (Point p : points) {
                if (p == curr) continue;
                if (next == null || cross(curr, next, p) < 0) next = p;
            }
            if (next == null) break;
            for (Point p : points) {
                if (p != curr && p != next && cross(curr, p, next) == 0) {
                    set.add(p);
                }
            }
            curr = next;
            next = null;
            if (curr == left) break;
            set.add(curr);
        }
        res.addAll(set);
        return res;
    }
    private int cross(Point p, Point a, Point b) {
        Point vec1 = new Point(a.x - p.x, a.y - p.y);
        Point vec2 = new Point(b.x - p.x, b.y - p.y);
        return vec1.x * vec2.y - vec1.y * vec2.x;
    }
}

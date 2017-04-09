/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int maxCount = 1;
        for (int i = 0; i < points.length; i++) {
            Set<Integer> visited = new HashSet<>();
            int same = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    visited.add(j);
                    same++;
                }
            }
            for (int j = i + 1; j < points.length; j++) {
                if (visited.contains(j)) continue;
                maxCount = Math.max(maxCount, same + visit(points[i], points, j, visited));
            }
            maxCount = Math.max(maxCount, same + 1);
        }
        return maxCount;
    }
    public int visit(Point p, Point[] points, int index, Set<Integer> visited) {
        long xeff = points[index].y - p.y;
        long yeff = p.x - points[index].x;
        long constant = -p.x * xeff - p.y * yeff;
        int count = 2;
        visited.add(index);
        for (int i = index + 1; i < points.length; i++) {
            if (visited.contains(i)) continue;
            if (points[i].x * xeff + points[i].y * yeff + constant == 0) {
                visited.add(i);
                count++;
            }
        }
        return count;
    }
}

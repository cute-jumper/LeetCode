public class ConvexPolygon {
    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        for (int i = 0, sign = 0; i < size; i++) {
            int c = cross(points.get(i), points.get((i + 1) % size), points.get((i + 2) % size));
            if (sign == 0) {
                if (c > 0) sign = 1;
                else if (c < 0) sign = -1;
            } else {
                if (!(c == 0 || sign == 1 && c > 0 || sign == -1 && c < 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    int cross(List<Integer> a, List<Integer> b, List<Integer> c) {
        int v1x = a.get(0) - b.get(0);
        int v1y = a.get(1) - b.get(1);
        int v2x = b.get(0) - c.get(0);
        int v2y = b.get(1) - c.get(1);
        return v1x * v2y - v1y * v2x;
    }
}

public class PerfectRectangle {
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return this.x == pair.x && this.y == pair.y;
        }
        @Override
        public int hashCode() {
            return 47 * this.x + this.y;
        }
    }
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Pair> set = new HashSet<>();
        int maxArea = 0;
        int areaSum = 0;
        int left = Integer.MAX_VALUE, right = 0, bottom = Integer.MAX_VALUE, top = 0;
        for (int[] rect : rectangles) {
            left = Math.min(left, rect[0]);
            bottom = Math.min(bottom, rect[1]);
            right = Math.max(right, rect[2]);
            top = Math.max(top, rect[3]);
            int area = (right - left) * (top - bottom);
            maxArea = Math.max(maxArea, area);
            areaSum += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            Pair[] corners = new Pair[] { new Pair(rect[0], rect[1]),
                                        new Pair(rect[0], rect[3]),
                                        new Pair(rect[2], rect[1]),
                                        new Pair(rect[2], rect[3]) };
            for (Pair corner : corners) {
                if (!set.add(corner)) set.remove(corner);
            }
        }
        if (set.size() != 4) return false;
        Pair[] corners = new Pair[] { new Pair(left, bottom),
                                    new Pair(left, top),
                                    new Pair(right, bottom),
                                    new Pair(right, top) };
        for (Pair corner : corners) {
            if (!set.contains(corner)) return false;
        }
        return maxArea == areaSum;
    }
}

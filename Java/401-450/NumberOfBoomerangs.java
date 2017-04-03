public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                    (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(dist)) {
                    res += 2 * map.get(dist);
                    map.put(dist, map.get(dist) + 1);
                } else {
                    map.put(dist, 1);
                }
            }
        }
        return res;
    }
}

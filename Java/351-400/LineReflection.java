public class LineReflection {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) return true;
        int sum = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
                sum += p[0];
            }
            map.get(p[0]).add(p[1]);
        }
        int s = 2 * sum / map.size();
        for (int[] p : points) {
            int x = s - p[0];
            if (!map.containsKey(x) || !map.get(x).contains(p[1])) return false;
        }
        return true;
    }
}

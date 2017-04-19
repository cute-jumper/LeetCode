public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> row : wall) {
            int s = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                s += row.get(i);
                if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                else map.put(s, 1);
                maxCount = Math.max(maxCount, map.get(s));
            }
        }
        return wall.size() - maxCount;
    }
}

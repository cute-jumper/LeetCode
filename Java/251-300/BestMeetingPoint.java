public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xs.add(j);
                    ys.add(i);
                }
            }
        }
        Collections.sort(xs);
        return getDist(xs) + getDist(ys);
    }
    private int getDist(List<Integer> list) {
        int dist = 0;
        for (int low = 0, high = list.size() - 1; low < high; low++, high--) {
            dist += list.get(high) - list.get(low);
        }
        return dist;
    }
}

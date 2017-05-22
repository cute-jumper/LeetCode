public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dists = new int[6];
        int[][] ps = new int[][] {p1, p2, p3, p4};
        for (int i = 0, index = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                dists[index++] = getDist(ps[i], ps[j]);
            }
        }
        Arrays.sort(dists);
        return dists[0] > 0 && dists[0] == dists[3] && dists[3] != dists[4] && dists[4] == dists[5];
    }
    private int getDist(int[] p1, int[] p2) {
        int x = p1[0] - p2[0];
        int y = p1[1] - p2[1];
        return x * x + y * y;
    }
}

public class LonelyPixel2 {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        int height = picture.length, width = picture[0].length;
        int[] rowCount = new int[height];
        Map<Integer, List<Integer>> c2r = new HashMap<>();
        String[] rows = new String[height];
        for (int i = 0; i < height; i++) {
            rows[i] = new String(picture[i]);
            for (int j = 0; j < width; j++) {
                if (picture[i][j] == 'B') {
                    rowCount[i]++;
                    if (!c2r.containsKey(j)) c2r.put(j, new ArrayList<>());
                    c2r.get(j).add(i);
                }
            }
        }
        int total = 0;
        for (List<Integer> rs : c2r.values()) {
            if (rs.size() != N) continue;
            String s = rows[rs.get(0)];
            boolean flag = rowCount[rs.get(0)] == N;
            for (int j = 1; j < rs.size() && flag; j++) {
                int r = rs.get(j);
                if (rowCount[r] != N || !s.equals(rows[r])) {
                    flag = false;
                }
            }
            if (flag) total += N;
        }
        return total;
    }
}

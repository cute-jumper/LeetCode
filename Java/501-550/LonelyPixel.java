public class LonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0 || picture[0].length == 0) return 0;
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 1) continue;
            for (int j = 0; j < col.length; j++) {
                if (picture[i][j] == 'B' && col[j] == 1) res++;
            }
        }
        return res;
    }
}

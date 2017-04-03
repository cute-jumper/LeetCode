public class MinimumNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[1] < b[1]) return -1;
                    if (a[1] > b[1]) return 1;
                    return 0;
                }
            });
        int[] current = points[0];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > current[1]) {
                res++;
                current = points[i];
            }
        }
        return res;
    }
}

public class MaximumDistanceInArrays {
    public int maxDistance(int[][] arrays) {
        int len = arrays.length;
        int[][] mins = new int[len][2];
        int[][] maxs = new int[len][2];
        for (int i = 0; i < len; i++) {
            mins[i][0] = arrays[i][0];
            maxs[i][0] = arrays[i][arrays[i].length - 1];
            mins[i][1] = maxs[i][1] = i;
        }
        Arrays.sort(mins, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        Arrays.sort(maxs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        if (maxs[0][1] != mins[0][1]) return maxs[0][0] - mins[0][0];
        int a = maxs[0][0] - mins[1][0];
        int b = maxs[1][0] - mins[0][0];
        return Math.max(a, b);
    }
}

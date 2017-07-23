public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[1] != b[1]) return a[1] - b[1];
                    return a[0] - b[0];
                }
            });
        int[] p = pairs[0];
        int len = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > p[1]) {
                len++;
                p = pairs[i];
            }
        }
        return len;
    }
}

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                if (a[0] > b[0]) return 1;
                return b[1] - a[1];
            }
        });
        int[] res = new int[envelopes.length];
        int index = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int found = Arrays.binarySearch(res, 0, index, envelopes[i][1]);
            if (found < 0) {
                found = -(found + 1);
                res[found] = envelopes[i][1];
                if (found == index) index++;
            }
        }
        return index;
    }
}

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[][] times = new int[timePoints.size()][];
        for (int i = 0; i < timePoints.size(); i++) {
            String[] t = timePoints.get(i).split(":");
            times[i] = new int[] { Integer.parseInt(t[0]), Integer.parseInt(t[1]) };
        }
        Arrays.sort(times, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] < b[0]) return -1;
                    if (a[0] > b[0]) return 1;
                    if (a[1] < b[1]) return -1;
                    if (a[1] > b[1]) return 1;
                    return 0;
                }
            });
        int[] prev = times[0];
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            minDiff = Math.min(minDiff, timeDiff(prev, times[i]));
            prev = times[i];
        }
        return Math.min(minDiff, timeDiff(times[0], prev));
    }
    public int timeDiff(int[] a, int[] b) {
        return Math.min(60 * (b[0] - a[0]) + b[1] - a[1],
                        60 * (a[0] + 24 - b[0]) + a[1] - b[1]);
    }
}

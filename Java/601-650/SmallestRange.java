public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) return new int[] {nums.get(0).get(0), nums.get(0).get(0)};
        int start = 0, diff = Integer.MAX_VALUE;
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for (int i = 0; i < nums.size(); i++) {
            set.add(new int[] { nums.get(i).get(0), i, 0 });
        }
        while (true) {
            int[] first = set.pollFirst();
            int[] last = set.last();
            if (last[0] - first[0] < diff) {
                start = first[0];
                diff = last[0] - first[0];
            }
            List<Integer> l = nums.get(first[1]);
            first[2]++;
            if (l.size() > first[2]) set.add(new int[] { l.get(first[2]), first[1], first[2] });
            else break;
        }
        return new int[] { start, start + diff };
    }
}

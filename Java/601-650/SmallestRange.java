public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums.size() == 1) return new int[] {nums.get(0).get(0), nums.get(0).get(0)};
        int start = 0, diff = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
            });
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new int[] { nums.get(i).get(0), i, 0 });
            end = Math.max(end, nums.get(i).get(0));
        }
        while (queue.size() == nums.size()) {
            int[] first = queue.poll();
            if (end - first[0] < diff) {
                start = first[0];
                diff = end - first[0];
            }
            List<Integer> l = nums.get(first[1]);
            first[2]++;
            if (l.size() > first[2]) {
                queue.offer(new int[] { l.get(first[2]), first[1], first[2] });
                end = Math.max(end, l.get(first[2]));
            }
        }
        return new int[] { start, start + diff };
    }
}

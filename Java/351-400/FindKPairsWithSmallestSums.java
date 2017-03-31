public class FindKPairsWithSmallestSums {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        @Override
        public int compareTo(Pair that) {
            return this.val - that.val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] indices = new int[nums1.length];
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < nums2.length)
                pq.add(new Pair(nums1[i] + nums2[indices[i]], i));
        }
        while (k > 0 && !pq.isEmpty()) {
            Pair p = pq.poll();
            res.add(new int[] { nums1[p.index], nums2[indices[p.index]] });
            k--;
            indices[p.index]++;
            if (indices[p.index] < nums2.length) {
                pq.add(new Pair(nums1[p.index] + nums2[indices[p.index]], p.index));
            }
        }
        return res;
    }
}

public class NumberOfCC {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.getCount();
    }
    private static class UnionFind {
        int[] nums;
        int[] rank;
        int count;
        public UnionFind(int n) {
            nums = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i;
                rank[i] = 1;
            }
            count = n;
        }
        public int find(int i) {
            while (nums[i] != i) {
                i = nums[i] = nums[nums[i]];
            }
            return i;
        }
        public void union(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2) {
                if (rank[r1] > rank[r2]) {
                    nums[r2] = r1;
                    rank[r1] += rank[r2];
                } else {
                    nums[r1] = r2;
                    rank[r2] += rank[r1];
                }
                count--;
            }
        }
        public int getCount() {
            return count;
        }
    }
}

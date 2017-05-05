public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }
        return uf.getCount() == 1;
    }
    private static class UnionFind {
        int[] nums;
        int count;
        public UnionFind(int n) {
            nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = i;
            count = n;
        }
        public int find(int i) {
            while (nums[i] != i) {
                nums[i] = nums[nums[i]];
                i = nums[i];
            }
            return i;
        }
        public boolean union(int i, int j) {
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2) {
                nums[r2] = r1;
                count--;
                return true;
            }
            return false;
        }
        public int getCount() {
            return count;
        }
    }
}

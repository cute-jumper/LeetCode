class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] e : edges) {
            set.add(e[0]);
            set.add(e[1]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i : set) map.put(i, cnt++);
        UnionFind uf = new UnionFind(map.size());
        for (int[] e : edges) {
            if (!uf.union(map.get(e[0]), map.get(e[1]))) return e;
        }
        return null;
    }
    class UnionFind {
        int[] nums;
        UnionFind(int n) {
            nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = i;
        }
        int find(int i) {
            while (nums[i] != i) {
                nums[i] = nums[nums[i]];
                i = nums[i];
            }
            return i;
        }
        boolean union(int i, int j) {
            int r1 = find(i), r2 = find(j);
            if (r1 == r2) return false;
            nums[r2] = r1;
            return true;
        }
    }
}

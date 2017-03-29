public class MinimumHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adjacent = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacent.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjacent.get(edges[i][0]).add(edges[i][1]);
            adjacent.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < adjacent.size(); i++) {
            if (adjacent.get(i).size() == 1) current.add(i);
        }
        for (int k = 0; k < n - 2;) {
            List<Integer> next = new ArrayList<>();
            for (Integer i : current) {
                int adj = adjacent.get(i).get(0);
                adjacent.get(adj).remove(i);
                if (adjacent.get(adj).size() == 1)
                    next.add(adj);
            }
            k += current.size();
            current = next;
        }
        return current;
    }
}

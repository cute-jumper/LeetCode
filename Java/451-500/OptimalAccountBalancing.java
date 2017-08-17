public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            add(map, tran[0], tran[2]);
            add(map, tran[1], -tran[2]);
        }
        List<Integer> balances = new ArrayList<>();
        for (Integer v : map.values()) {
            if (v != 0) balances.add(v);
        }
        return dfs(balances, 0, 0);
    }
    int dfs(List<Integer> balances, int start, int count) {
        while (start < balances.size() && balances.get(start) == 0) start++;
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < balances.size(); i++) {
            if (balances.get(start) * balances.get(i) < 0) {
                balances.set(i, balances.get(i) + balances.get(start));
                min = Math.min(min, dfs(balances, start + 1, count + 1));
                balances.set(i, balances.get(i) - balances.get(start));
            }
        }
        return min == Integer.MAX_VALUE ? count : min;
    }
    void add(Map<Integer, Integer> map, int k, int v) {
        if (map.containsKey(k)) map.put(k, map.get(k) + v);
        else map.put(k, v);
    }
}

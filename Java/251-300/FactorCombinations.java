public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> prefix, int n) {
        if (prefix.size() > 0) {
            List<Integer> factors = new ArrayList<>(prefix);
            factors.add(n);
            res.add(factors);
        }
        int start = prefix.isEmpty() ? 2 : prefix.get(prefix.size() - 1);
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                prefix.add(i);
                dfs(res, prefix, n / i);
                prefix.remove(prefix.size() - 1);
            }
        }
    }
}

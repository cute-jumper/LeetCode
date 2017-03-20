public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        return genCombinations(n, k, 0);

    }
    public List<List<Integer>> genCombinations(int n, int k, int start) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        for (int i = start; i < n; i++) {
            List<List<Integer>> combs = genCombinations(n, k - 1, i + 1);
            for (List<Integer> c : combs) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(i + 1);
                subRes.addAll(c);
                res.add(subRes);
            }
        }
        return res;
    }
}

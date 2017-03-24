public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        genCombinationSum(res, new ArrayList<Integer>(), 1, k, n);
        return res;
    }
    public void genCombinationSum(List<List<Integer>> res, List<Integer> curr, int start, int k, int n) {
        if (k == 0) {
            if (n == 0) res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = start; i < 10 && i <= n; i++) {
            curr.add(i);
            genCombinationSum(res, curr, i + 1, k - 1, n - i);
            curr.remove(curr.size() - 1);
        }
    }
}

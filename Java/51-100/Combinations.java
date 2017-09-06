public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 1, k);
        return res;
    }
    void helper(List<List<Integer>> res, List<Integer> curr, int n, int start, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            helper(res, curr, n, i + 1, k);
            curr.remove(curr.size() - 1);
        }
    }
}

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int start, int target) {
        if (target <= 0) {
            if (target == 0) res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(res, curr, candidates, i, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}

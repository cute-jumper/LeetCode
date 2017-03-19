public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return getCombinationSum(candidates, 0, target);
    }
    public List<List<Integer>> getCombinationSum(int[] candidates, int low, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        if (candidates[low] > target) return null;
        for (int i = low; i < candidates.length; i++) {
            List<List<Integer>> combs = getCombinationSum(candidates, i, target - candidates[i]);
            if (combs != null) {
                for (List<Integer> lst : combs) {
                    ArrayList<Integer> subRes = new ArrayList<>();
                    subRes.add(candidates[i]);
                    subRes.addAll(lst);
                    res.add(subRes);
                }
            }
        }
        return res;
    }
}

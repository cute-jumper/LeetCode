public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> subRes = getCombinationSum(candidates, i, target, 0);
            if (subRes != null) res.addAll(subRes);
        }
        return res;
    }
    public List<List<Integer>> getCombinationSum(int[] candidates, int low, int target, int depth) {
        List<List<Integer>> res = new ArrayList<>();
        if (depth == 0) target -= candidates[low];
        if (target == 0) {
            if (depth == 0) {
                List<Integer> subRes = new ArrayList<Integer>();
                subRes.add(candidates[low]);
                res.add(subRes);
            } else {
                res.add(new ArrayList<Integer>());
            }
            return res;
        }
        if (candidates[low] > target) return null;
        for (int i = low; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                List<List<Integer>> combs = getCombinationSum(candidates, i, target - candidates[i], depth + 1);
                if (combs != null) {
                    for (List<Integer> lst : combs) {
                        ArrayList<Integer> subRes = new ArrayList<>();
                        if (depth == 0) subRes.add(candidates[low]);
                        subRes.add(candidates[i]);
                        subRes.addAll(lst);
                        res.add(subRes);
                    }
                }
            }
        }
        return res;
    }
}

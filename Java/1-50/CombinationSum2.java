public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = getCombinationSum2(candidates, 0, target);
        return res == null ? new ArrayList<List<Integer>>() : res;
    }
    public List<List<Integer>> getCombinationSum2(int[] candidates,
                                                  int start,
                                                  int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target == 0) {
            List<Integer> subRes = new ArrayList<>();
            res.add(subRes);
            return res;
        }
        if (candidates.length == start || candidates[start] > target) return null;
        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            while (i < candidates.length && candidates[i] == prev) i++;
            if (i < candidates.length) {
                prev = candidates[i];
                List<List<Integer>> combs = getCombinationSum2(candidates, i + 1, target - candidates[i]);
                if (combs != null) {
                    for (List<Integer> c : combs) {
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(candidates[i]);
                        subRes.addAll(c);
                        res.add(subRes);
                    }
                }
            }
        }
        return res;
    }
}

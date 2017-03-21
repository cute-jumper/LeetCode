public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return genSubsets(nums, 0);
    }
    public List<List<Integer>> genSubsets(int[] nums, int start) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (start == nums.length) {
            return res;
        }
        int current = nums[0] - 1;
        for (int i = start; i < nums.length; i++) {
            if (current == nums[i]) continue;
            current = nums[i];
            List<List<Integer>> subsets = genSubsets(nums, i + 1);
            for (List<Integer> subset : subsets) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(current);
                subRes.addAll(subset);
                res.add(subRes);
            }
        }
        return res;
    }
}

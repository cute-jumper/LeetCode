public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        if (curr.size() > 1) res.add(new ArrayList<>(curr));
        Set<Integer> prev = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (prev.add(nums[i]) && (curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1))) {
                curr.add(nums[i]);
                helper(res, curr, nums, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

public class  {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<>(), nums, 0);
        return res;
    }
    void subsets(List<List<Integer>> res, List<Integer> curr, int[] nums, int start) {
        res.add(new ArrayList<>(curr));
        if (start == nums.length) return;
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}

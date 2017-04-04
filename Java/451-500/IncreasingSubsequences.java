public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getSeq(res, new ArrayList<>(), nums, 0);
        return res;
    }
    public void getSeq(List<List<Integer>> res, List<Integer> prefix,
                                      int[] nums, int start) {
        if (prefix.size() > 1) {
            res.add(new ArrayList<Integer>(prefix));
        }
        if (start == nums.length) return;
        Set<Integer> prev = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (prev.contains(nums[i])) continue;
            if (prefix.size() == 0 || nums[i] >= prefix.get(prefix.size() - 1)) {
                prefix.add(nums[i]);
                getSeq(res, prefix, nums, i + 1);
                prefix.remove(prefix.size() - 1);
                prev.add(nums[i]);
            }
        }
    }
}

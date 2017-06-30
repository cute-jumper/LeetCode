public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        kSum(res, nums, target, 0, nums.length - 1, new ArrayList<>(), 4);
        return res;
    }
    private void kSum(List<List<Integer>> res, int[] nums, int target, int low, int high, List<Integer> curr, int k) {
        if (high - low + 1 < k) return;
        if (k == 2) {
            while (low < high) {
                int s = nums[low] + nums[high];
                if (s < target) low++;
                else if (s > target) high--;
                else {
                    List<Integer> list = new ArrayList<>(curr);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    res.add(list);
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high - 1] == nums[high]) high--;
                    low++;
                    high--;
                }
            }
        } else {
            for (int i = low; i + k - 1 <= high; i++) {
                if (i > low && nums[i] == nums[i - 1]) continue;
                curr.add(nums[i]);
                kSum(res, nums, target - nums[i], i + 1, high, curr, k - 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

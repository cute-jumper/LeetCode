public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            nums[val - 1] = -nums[val - 1];
            if (nums[val - 1] > 0) res.add(val);
        }
        return res;
    }
}

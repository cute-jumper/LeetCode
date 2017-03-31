public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        List<Integer> candidates = new ArrayList<>();
        candidates.add(nums[0]);
        int type = 0;
        for (int i = 1; i < nums.length; i++) {
            int last = candidates.get(candidates.size() - 1);
            if (nums[i] == last) continue;
            if (type == 0) {
                if (nums[i] > last) {
                    type = 1;
                } else {
                    type = -1;
                }
                candidates.add(nums[i]);
            } else if (nums[i] > last && type == 1 || nums[i] < last && type == -1) {
                candidates.set(candidates.size() - 1, nums[i]);
            } else {
                candidates.add(nums[i]);
                type = -type;
            }
        }
        return candidates.size();
    }
}

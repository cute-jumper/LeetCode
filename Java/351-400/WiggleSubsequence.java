public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int recent = nums[0];
        int count = 1;
        int type = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == recent) continue;
            if (type == 0) {
                type = nums[i] > recent ? 1 : -1;
                count++;
            } else if (nums[i] > recent && type == -1 || nums[i] < recent && type == 1) {
                type = -type;
                count++;
            }
            recent = nums[i];
        }
        return count;
    }
}

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        boolean found = false;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!found && nums[i] == 1) {
                found = true;
                start = i;
            } else if (found && nums[i] == 0) {
                found = false;
                max = Math.max(i - start, max);
            }
        }
        if (found) max = Math.max(nums.length - start, max);
        return max;
    }
}

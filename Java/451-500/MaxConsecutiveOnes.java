public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0, start = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                max = Math.max(max, i - start);
                start = i + 1;
            }
        }
        return max;
    }
}

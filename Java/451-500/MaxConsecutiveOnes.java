public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0, cnt = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                max = Math.max(cnt, max);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return max;
    }
}

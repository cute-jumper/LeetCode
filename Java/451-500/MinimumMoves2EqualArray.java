public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
        }
        int count = 0;
        for (int i : nums) {
            count += i - min;
        }
        return count;
    }
}

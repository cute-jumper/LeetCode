public class Solution {

    Random rand = new Random();
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int selected = 0;
        for (int i = 0; i < this.nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0)
                    selected = i;
            }
        }
        return selected;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

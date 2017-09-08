public class ShortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, low = -1, high = -2;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - i - 1]);
            if (nums[i] < max) high = i;
            if (nums[nums.length - i - 1] > min) low = nums.length - i - 1;
        }
        return high - low + 1;
    }
}

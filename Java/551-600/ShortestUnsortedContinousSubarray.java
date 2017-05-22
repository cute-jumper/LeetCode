public class ShortestUnsortedContinousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int low = 0;
        for (; low < nums.length - 1; low++) {
            if (nums[low] > nums[low + 1]) break;
        }
        if (low == nums.length - 1) return 0;
        int maxVal = nums[low];
        int high = low + 1;
        for (int i = high; i < nums.length; i++) {
            if (nums[i] >= maxVal) maxVal = nums[i];
            else {
                while (low > 0 && nums[low-1] > nums[i]) {
                    low--;
                }
                high = i;
            }
        }
        return high - low + 1;
    }
}

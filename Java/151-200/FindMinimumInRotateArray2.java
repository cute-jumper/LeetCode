public class FindMinimumInRotateArray2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high && nums[low] == nums[high]) {
            low++;
            high--;
        }
        if (low >= high || nums[low] < nums[high]) return Math.min(nums[0], nums[low]);
        int head = nums[low];
        int end = nums[high];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= head) {
                low = mid + 1;
            } else if (nums[mid] <= end) {
                high = mid;
            }
        }
        return nums[low];
    }
}

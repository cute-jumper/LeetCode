public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] < nums[high]) {
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            } else if (nums[mid] > nums[high]) {
                if (nums[mid] > target && nums[low] <= target) high = mid - 1;
                else low = mid + 1;
            } else {
                high--;
            }
        }
        return nums[low] == target;
    }
}

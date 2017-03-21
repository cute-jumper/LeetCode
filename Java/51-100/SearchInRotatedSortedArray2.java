public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int low = 0;
        int high = nums.length - 1;
        if (target == nums[0]) return true;
        if (nums[0] == nums[nums.length - 1]) {
            while (low <= high && nums[low] == nums[0]) low++;
            while (high >= low && nums[high] == nums[0]) high--;
            if (low > high) return false;
            if (low == high)
                return nums[low] == target;
        }
        int type = 0;
        int start = nums[low];
        int end = nums[high];
        if (nums[low] > nums[high]) {
            if (target >= nums[low]) type = 1;
            else if (target <= nums[high]) type = 2;
            else return false;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if (type == 1 && nums[mid] <= end) {
                high = mid - 1;
            } else if (type == 2 && nums[mid] >= start) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}

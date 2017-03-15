public class SearchInsertPosition {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int pivot = findPivot(nums);
        int low, high;
        if (target >= nums[0] && target <= nums[pivot]) {
            low = 0;
            high = pivot;
        } else if (pivot < nums.length - 1 && target >= nums[pivot + 1] &&
                   target <= nums[nums.length - 1]) {
            low = pivot + 1;
            high = nums.length - 1;
        } else {
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public int findPivot(int[] nums) {
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}

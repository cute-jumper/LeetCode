public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int pivotIndex = findPivotIndex(nums);
        int low, high;
        if (pivotIndex == nums.length) {
            if (target < nums[0] || target > nums[nums.length - 1]) return false;
            low = 0;
            high = pivotIndex - 1;
        } else {
            if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
                low = 0;
                high = pivotIndex - 1;
            } else if (target >= nums[pivotIndex] && target <= nums[nums.length - 1]) {
                low = pivotIndex;
                high = nums.length - 1;
            } else {
                return false;
            }
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public int findPivotIndex(int[] nums) {
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= prev) {
                prev = nums[i];
            } else {
                return i;
            }
        }
        return nums.length;
    }
}

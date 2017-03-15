public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (nums[low] > target) {
            return low;
        } else if (nums[high] < target) {
            return high + 1;
        }
        return high;
    }
}

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { -1, -1 };
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= nums[mid]) {
                high = mid;
            } else {
                low =  mid + 1;
            }
        }
        if (nums[low] != target) return new int[] { -1, -1 };
        int lowerBound = low;
        low = 0;
        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high - 1) / 2 + 1;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low =  mid;
            }
        }
        return new int[] { lowerBound, low };
    }
}

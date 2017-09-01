public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        if (nums.length == 0) return res;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }
        if (nums[low] != target) return res;
        res[0] = low;
        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target) low = mid;
            else high = mid - 1;
        }
        res[1] = low;
        return res;
    }
}

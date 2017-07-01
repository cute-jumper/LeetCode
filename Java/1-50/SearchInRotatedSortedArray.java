public class SearchInsertPosition {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0, high = nums.length - 1, first = nums[0], last = nums[nums.length - 1];
        int type = 0;
        if (first > last) {
            if (target > last) type = 1;
            else type = 2;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                if (type != 2 || nums[mid] <= last) high = mid - 1;
                else low = mid + 1;
            } else {
                if (type != 1 || nums[mid] >= first) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}

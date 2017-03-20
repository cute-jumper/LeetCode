public class SearchInsertPosition {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        int type = 0;
        if (nums[0] > nums[nums.length - 1]) {
            if (target >= nums[0]) type = 1;
            else type = 2;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            if (type == 1 && nums[mid] < nums[0]) {
                high = mid - 1;
            } else if (type == 2 && nums[mid] > nums[nums.length - 1]) {
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

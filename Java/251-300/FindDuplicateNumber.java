public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countBelow(nums, mid);
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    public int countBelow(int[] nums, int bound) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= bound) count++;
        }
        return count;
    }
}

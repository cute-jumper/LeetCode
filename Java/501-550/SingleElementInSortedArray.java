public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid == 0) return nums[0];
            int v = nums[mid ^ 1];
            if (nums[mid] != v) {
                high = mid & (~1);
            } else {
                low = (mid | 1) + 1;
            }
        }
        return nums[low];
    }
}

public class MinimumMoves2EqualArray2 {
    public int minMoves2(int[] nums) {
        int median = quickSelect(nums, (nums.length - 1) / 2);
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += Math.abs(nums[i] - median);
        }
        return total;
    }
    public int quickSelect(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        int pivotIndex = partition(nums, low, high);
        while (pivotIndex != k) {
            if (pivotIndex > k) {
                high = pivotIndex - 1;
            } else {
                low = pivotIndex + 1;
            }
            pivotIndex = partition(nums, low, high);
        }
        return nums[k];
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
        nums[high] = nums[index];
        nums[index] = pivot;
        return index;
    }
}

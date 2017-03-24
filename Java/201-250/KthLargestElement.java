public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k - 1);
    }
    public int quickselect(int[] nums, int low, int high, int k) {
        if (low == high) return nums[low];
        int pivotIndex = partition(nums, low, high);
        if (pivotIndex == k) return nums[k];
        if (pivotIndex < k) return quickselect(nums, pivotIndex + 1, high, k);
        return quickselect(nums, low, pivotIndex - 1, k);
    }
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] > pivot) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                index++;
            }
        }
        nums[high] = nums[index];
        nums[index] = pivot;
        return index;
    }
}

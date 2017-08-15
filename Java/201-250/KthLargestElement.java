public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int index = partition(nums, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = partition(nums, low, high);
        }
        return nums[index];
    }
    int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (nums[i] > pivot) {
                swap(nums, index++, i);
            }
        }
        swap(nums, index, high);
        return index;
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

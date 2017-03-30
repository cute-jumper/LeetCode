public class WiggleSort2 {
    public void wiggleSort(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1, (nums.length - 1)/ 2);
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            int index = (1 + 2 * mid) % (nums.length | 1);
            if (nums[index] > median) {
                int leftIndex = (1 + 2 * left) % (nums.length | 1);
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[index];
                nums[index] = tmp;
                left++;
                mid++;
            } else if (nums[index] < median) {
                int rightIndex = (1 + 2 * right) % (nums.length | 1);
                int tmp = nums[rightIndex];
                nums[rightIndex] = nums[index];
                nums[index] = tmp;
                right--;
            } else {
                mid++;
            }
        }
    }


    public int quickSelect(int[] nums, int low, int high, int k) {
        int pivotIndex = partition(nums, low, high);
        // if (pivotIndex == k) return nums[k];
        // if (pivotIndex > k) return quickSelect(nums, low, pivotIndex - 1, k);
        // return quickSelect(nums, pivotIndex + 1, high, k);
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

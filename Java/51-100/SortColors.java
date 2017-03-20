public class SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    public int partition(int[] nums, int low, int high) {
        int i = low - 1;
        int pivot = nums[high];
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        i++;
        int tmp = nums[i];
        nums[i] = nums[high];
        nums[high] = tmp;
        return i;
    }
}

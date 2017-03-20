public class SortColors {
    public void sortColors(int[] nums) {
        // quickSort(nums, 0, nums.length - 1);
        int zeroIndex = -1;
        int oneCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex++;
                nums[zeroIndex] = 0;
            } else if (nums[i] == 1) {
                oneCount++;
            }
        }
        for (int i = zeroIndex + 1; i <= zeroIndex + oneCount; i++)
            nums[i] = 1;
        for (int i = zeroIndex + oneCount + 1; i < nums.length; i++)
            nums[i] = 2;
    }

    // public void quickSort(int[] nums, int low, int high) {
    //     if (low >= high) return;
    //     int p = partition(nums, low, high);
    //     quickSort(nums, low, p - 1);
    //     quickSort(nums, p + 1, high);
    // }

    // public int partition(int[] nums, int low, int high) {
    //     int i = low - 1;
    //     int pivot = nums[high];
    //     for (int j = low; j <= high - 1; j++) {
    //         if (nums[j] < pivot) {
    //             i++;
    //             int tmp = nums[i];
    //             nums[i] = nums[j];
    //             nums[j] = tmp;
    //         }
    //     }
    //     i++;
    //     int tmp = nums[i];
    //     nums[i] = nums[high];
    //     nums[high] = tmp;
    //     return i;
    // }
}

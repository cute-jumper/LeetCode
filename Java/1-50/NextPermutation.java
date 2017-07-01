public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) index--;
        if (index >= 0) {
            int val = nums[index];
            int replace = nums.length - 1;
            while (replace > index && nums[replace] <= val) replace--;
            swap(nums, index, replace);
        }
        reverse(nums, index + 1, nums.length - 1);
    }
    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

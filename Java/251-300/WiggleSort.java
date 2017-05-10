public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]) swap(nums, i, i - 1);
            else if (i % 2 == 0 && nums[i] > nums[i - 1]) swap(nums, i, i - 1);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

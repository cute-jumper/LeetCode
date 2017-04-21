public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0, curr = 0, two = nums.length - 1;
        while (curr <= two) {
            if (nums[curr] == 0) swap(nums, zero++, curr++);
            else if (nums[curr] == 1) curr++;
            else swap(nums, curr, two--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

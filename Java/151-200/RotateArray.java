public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;
        int mid = nums.length - k - 1;
        reverse(nums, 0, mid);
        reverse(nums, mid + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}

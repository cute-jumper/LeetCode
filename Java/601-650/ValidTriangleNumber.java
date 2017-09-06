public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int i = nums.length - 1; i > 1; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                if (nums[low] + nums[high] > nums[i]) {
                    total += high - low;
                    high--;
                }
                else low++;
            }
        }
        return total;
    }
}

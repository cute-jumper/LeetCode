public class MissingNumber {
    public int missingNumber(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (int)((long)(nums.length + 1) * nums.length / 2 - sum);
    }
}

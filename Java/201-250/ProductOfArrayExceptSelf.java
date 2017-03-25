public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i];
        }
        int product = nums[nums.length - 1];
        output[nums.length - 1] = output[nums.length - 2];
        for (int i = nums.length - 2; i > 0; i--) {
            output[i] = product * output[i - 1];
            product *= nums[i];
        }
        output[0] = product;
        return output;
    }
}

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long[] res = new long[3];
        Arrays.fill(res, Integer.MIN_VALUE - 1L);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > res[0]) {
                res[2] = res[1];
                res[1] = res[0];
                res[0] = nums[i];
            } else if (nums[i] > res[1] && nums[i] < res[0]) {
                res[2] = res[1];
                res[1] = nums[i];
            } else if (nums[i] > res[2] && nums[i] < res[1]) {
                res[2] = nums[i];
            }
        }
        if (res[2] == Integer.MIN_VALUE - 1L) return (int)res[0];
        else return (int)res[2];
    }
}

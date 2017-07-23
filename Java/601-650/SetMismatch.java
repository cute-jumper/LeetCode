public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        long s = 0;
        int rep = 0;
        int n = nums.length;
        for (int i : nums) {
            int j = Math.abs(i) - 1;
            s += j + 1;
            if (nums[j] < 0) rep = j + 1;
            else nums[j] = -nums[j];
        }
        return new int[] { rep, (int)(n * (long)(n+1) / 2 - s + rep) };
    }
}

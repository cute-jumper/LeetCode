public class NumArray {
    int[] prefixSums;

    public NumArray(int[] nums) {
        this.prefixSums = new int[nums.length + 1];
        this.prefixSums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            this.prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefixSums[j + 1] - prefixSums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

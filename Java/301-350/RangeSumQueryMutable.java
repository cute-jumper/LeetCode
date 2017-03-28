public class NumArray {

    int[] bit;

    private int lowBit(int n) {
        return (n & (-n));
    }

    public NumArray(int[] nums) {
        bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            bit[i + 1] += nums[i];
            int j = i + 1 + lowBit(i + 1);
            if (j <= nums.length) bit[j] += bit[i + 1];
        }
    }

    public void update(int i, int val) {
        int diff = val - sumRange(i, i);
        for (int j = i + 1; j < bit.length; j += lowBit(j)) {
            bit[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (j + 1 > i) {
            sum += bit[j + 1];
            j -= lowBit(j + 1);
        }
        while (i - 1 > j) {
            sum += bit[i];
            i -= lowBit(i);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

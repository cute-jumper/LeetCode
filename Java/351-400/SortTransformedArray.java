public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        boolean inc = a == 0 ? b > 0 : a < 0;
        int low = 0, high = nums.length - 1;
        int index = inc ? 0 : nums.length - 1;
        int[] res = new int[nums.length];
        while (low <= high) {
            int v1 = calc(a, b, c, nums[low]);
            int v2 = calc(a, b, c, nums[high]);
            if (inc) {
                if (v1 < v2) {
                    res[index++] = v1;
                    low++;
                } else {
                    res[index++] = v2;
                    high--;
                }
            } else {
                if (v1 < v2) {
                    res[index--] = v2;
                    high--;
                } else {
                    res[index--] = v1;
                    low++;
                }
            }
        }
        return res;
    }
    private int calc(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}

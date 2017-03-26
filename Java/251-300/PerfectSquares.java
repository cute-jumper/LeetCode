public class PerfectSquares {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minCount = Math.min(minCount, nums[i - j * j] + 1);
            }
            nums[i] = minCount;
        }
        return nums[n];
    }
}

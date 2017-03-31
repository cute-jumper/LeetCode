public class LargestDivisableSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = -1;
        int maxIndex = 0;
        int maxLen = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                }
            }
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                maxIndex = i;
            }
        }
        for (int i = maxIndex; i >= 0; i = dp[i][1]) {
            res.add(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
}

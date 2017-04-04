public class MatchSticks2Square {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum == 0 || sum % 4 != 0) return false;
        Arrays.sort(nums);
        return dfs(nums, new int[4], nums.length - 1, sum / 4);
    }
    public boolean dfs(int[] nums, int[] sums, int current, int target) {
        if (current == -1)
            return sums[0] == target && sums[1] == target && sums[2] == target &&
                sums[3] == target;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[current] <= target) {
                sums[i] += nums[current];
                if (dfs(nums, sums, current - 1, target)) return true;
                sums[i] -= nums[current];
            }
        }
        return false;
    }
}

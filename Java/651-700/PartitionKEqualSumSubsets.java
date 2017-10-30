class PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int s = 0;
        for (int i : nums) s += i;
        if (s % k != 0) return false;
        return canPartition(nums, k, new boolean[nums.length], 0, s / k, 0);
    }
    boolean canPartition(int[] nums, int k, boolean[] visited, int curr, int target, int start) {
        if (k == 1) return true;
        if (curr >= target) return curr == target && canPartition(nums, k - 1, visited, 0, target, 0);
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, k, visited, curr + nums[i], target, start + 1)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}

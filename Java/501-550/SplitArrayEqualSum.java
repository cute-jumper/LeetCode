public class SplitArrayEqualSum {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7) return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) sum[i] = sum[i - 1] + nums[i];
        for (int mid = 3; mid + 3 < nums.length; mid++) {
            Set<Integer> set = new HashSet<>();
            for (int f = 1; f + 1 < mid; f++) {
                if (sum[f - 1] == sum[mid - 1] - sum[f]) set.add(sum[f - 1]);
            }
            for (int t = mid + 2; t + 1 < nums.length; t++) {
                if (sum[t - 1] - sum[mid] == sum[nums.length - 1] - sum[t] &&
                    set.contains(sum[t - 1] - sum[mid]))
                    return true;
            }
        }
        return false;
}

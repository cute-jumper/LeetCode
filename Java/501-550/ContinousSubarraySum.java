public class ContinouseSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        int[] sum = new int[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        sum[0] = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            int mod = k != 0 ? sum[i + 1] % k : sum[i + 1];
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) return true;
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}

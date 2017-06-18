public class SplitArrayEqualSum {
    public boolean splitArray(int[] nums) {
        int len = nums.length;
        if (len < 7) return false;
        int[] sum = new int[len];
        Map<Integer, List<Integer>> index = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum[i] = nums[i];
            if (i > 0) sum[i] += sum[i - 1];
            add(map, sum[i], i);
            add(index, nums[i], i);
        }
        int total = sum[len - 1];
        for (int i = 1; i + 5 < len; i++) {
            int s = sum[i - 1];
            int key = total - s;
            if (!map.containsKey(key)) continue;
            List<Integer> list = map.get(key);
            for (int j : list) {
                if (j < i + 4 || j >= len - 1) continue;
                int mid = sum[j - 1] - sum[i];
                int diff = mid - 2 * s;
                if (!index.containsKey(diff)) continue;
                List<Integer> cands = index.get(diff);
                for (int k : cands) {
                    if (k > i + 1 && k + 1 < j) return true;
                }
            }
        }
        return false;
    }
    void add(Map<Integer, List<Integer>> map, int key, int value) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(value);
    }
}

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<List<Integer>> count = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            count.add(new ArrayList<Integer>());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (!count.get(i).isEmpty()) {
                for (Integer j : count.get(i)) {
                    res.add(j);
                    k--;
                    if (k == 0) break;
                }
            }
        }
        return res;
    }
}

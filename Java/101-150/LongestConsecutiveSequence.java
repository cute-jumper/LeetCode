public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : nums) {
            if (set.add(i)) {
                int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
                int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;
                int len = left + 1 + right;
                max = Math.max(max, len);
                map.put(i - left, len);
                map.put(i + right, len);
            }
        }
        return max;
    }
}

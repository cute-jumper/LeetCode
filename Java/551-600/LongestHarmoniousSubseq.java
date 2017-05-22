public class LongestHarmoniousSubseq {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 0);
            map.put(i, map.get(i) + 1);
            if (map.containsKey(i - 1))
                maxLen = Math.max(maxLen, map.get(i - 1) + map.get(i));
            if (map.containsKey(i + 1))
                maxLen = Math.max(maxLen, map.get(i + 1) + map.get(i));
        }
        return maxLen;
    }
}

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int diff = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) diff++;
            else diff--;
            if (map.containsKey(diff)) {
                int prevIndex = map.get(diff);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(diff, i);
            }
        }
        return maxLen;
    }
}

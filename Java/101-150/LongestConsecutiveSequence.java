public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> intervals = new HashMap<>();
        int maxLen = 1;
        Set<Integer> shown = new HashSet<>();
        for (int i : nums) {
            if (shown.contains(i)) continue;
            if (intervals.containsKey(i - 1) && intervals.containsKey(i + 1)) {
                int low = intervals.get(i - 1);
                int high = intervals.get(i + 1);
                intervals.put(low, high);
                intervals.put(high, low);
                if (low != i - 1) intervals.remove(i - 1);
                if (high != i + 1) intervals.remove(i + 1);
                maxLen = Math.max(high - low + 1, maxLen);
            } else if (intervals.containsKey(i - 1)) {
                int low = intervals.get(i - 1);
                if (low > i - 1) continue;
                intervals.put(low, i);
                intervals.put(i, low);
                if (low != i - 1) intervals.remove(i - 1);
                maxLen = Math.max(i - low + 1, maxLen);
            } else if (intervals.containsKey(i + 1)) {
                int high = intervals.get(i + 1);
                if (high < i + 1) continue;
                intervals.put(i, high);
                intervals.put(high, i);
                if (high != i + 1) intervals.remove(i + 1);
                maxLen = Math.max(high - i + 1, maxLen);
            } else {
                intervals.put(i, i);
            }
            shown.add(i);
        }
        return maxLen;
    }
}

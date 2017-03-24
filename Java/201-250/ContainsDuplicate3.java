public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k <= 0) return false;
        Map<Long, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                lastSeen.remove(nums[i - k - 1] / ((long)t + 1));
            long index = nums[i] / ((long)t + 1);
            if (nums[i] < 0) index--;
            if (lastSeen.containsKey(index)) return true;
            if (lastSeen.containsKey(index - 1)) {
                int value = lastSeen.get(index - 1);
                if (nums[i] - (long)value <= (long)t) return true;
            }
            if (lastSeen.containsKey(index + 1)) {
                int value = lastSeen.get(index + 1);
                if (value - (long)nums[i] <= (long)t) return true;
            }
            lastSeen.put(index, nums[i]);
        }
        return false;
    }
}

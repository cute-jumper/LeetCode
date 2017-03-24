public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (lastSeen.containsKey(nums[i])) {
                int index = lastSeen.get(nums[i]);
                if (i - index <= k) return true;
            }
            lastSeen.put(nums[i], i);
        }
        return false;
    }
}

public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, new PriorityQueue<>());
            if (map.containsKey(i - 1) && !map.get(i - 1).isEmpty()) map.get(i).offer(map.get(i - 1).poll() + 1);
            else map.get(i).offer(1);
        }
        for (PriorityQueue<Integer> q : map.values()) {
            if (!q.isEmpty() && q.peek() < 3) return false;
        }
        return true;
    }
}

public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(), next = new HashMap<>();
        for (int i : nums) {
            add(map, i);
        }
        for (int i : nums) {
            if (map.get(i) <= 0) continue;
            if (next.containsKey(i) && next.get(i) > 0) {
                add(next, i + 1);
                minus(next, i);
            } else if (map.containsKey(i + 1) && map.get(i + 1) > 0 && map.containsKey(i + 2) && map.get(i + 2) > 0) {
                minus(map, i + 1);
                minus(map, i + 2);
                add(next, i + 3);
            } else {
                return false;
            }
            minus(map, i);
        }
        return true;
    }
    void add(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) map.put(key, map.get(key) + 1);
        else map.put(key, 1);
    }
    void minus(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
    }
}

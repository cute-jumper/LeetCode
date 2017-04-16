public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i : stones) map.put(i, new HashSet<>());
        map.get(0).add(1);
        int last = stones[stones.length - 1];
        for (int i = 0; i < stones.length - 1; i++) {
            Set<Integer> lens = map.get(stones[i]);
            for (int len : lens) {
                int next = stones[i] + len;
                if (next == last) return true;
                if (map.containsKey(next)) {
                    map.get(next).add(len);
                    map.get(next).add(len + 1);
                    if (len > 1) map.get(next).add(len - 1);
                }
            }
        }
        return false;
    }
}

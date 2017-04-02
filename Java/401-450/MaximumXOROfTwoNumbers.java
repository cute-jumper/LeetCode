public class MaximumXOROfTwoNumbers {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> leading = new HashSet<>();
            for (int n : nums) {
                leading.add(n & mask);
            }
            int trial = max | (1 << i);
            for (int n : leading) {
                if (leading.contains(n ^ trial)) {
                    max = trial;
                    break;
                }
            }
        }
        return max;
    }
}

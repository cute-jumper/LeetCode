public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int n : nums) {
                if ((n & (1 << i)) != 0) ones++;
            }
            total += ones * (nums.length - ones);
        }
        return total;
    }
}

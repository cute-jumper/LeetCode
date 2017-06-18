public class MaxConsecutiveOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        for (int i = 0, z = 0, start = 0; i < nums.length; i++) {
            if (nums[i] == 0) z++;
            while (z > 1) {
                if (nums[start++] == 0) z--;
            }
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}

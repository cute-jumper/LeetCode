public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int count = 0;
        while (xor != 0) {
            if ((xor & 1) == 1) break;
            xor >>>= 1;
            count++;
        }
        int mask = 1 << count;
        int first = 0, second = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) != 0) first ^= nums[i];
            else second ^= nums[i];
        }
        return new int[] { first, second };
    }
}

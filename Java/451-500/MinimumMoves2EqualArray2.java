public class MinimumMoves2EqualArray2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int total = 0, low = 0, high = nums.length - 1;
        while (low < high) total += nums[high--] - nums[low++];
        return total;
    }
}

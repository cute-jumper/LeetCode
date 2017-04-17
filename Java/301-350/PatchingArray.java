public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long maxVal = 0;
        int count = 0;
        int index = 0;
        while (index <= nums.length && maxVal < (long)n) {
            if (index == nums.length || nums[index] > maxVal + 1) {
                count++;
                maxVal += maxVal + 1;
            } else {
                maxVal += nums[index];
                index++;
            }
        }
        return count;
    }
}

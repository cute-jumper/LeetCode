public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > second) return true;
            if (nums[i] <= first) {
                first = nums[i];
            } else {
                second = nums[i];
            }
        }
        return false;
    }
}

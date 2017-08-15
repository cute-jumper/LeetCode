public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= s1) s1 = i;
            else if (i <= s2) s2 = i;
            else return true;
        }
        return false;
    }
}

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                m = nums[i];
                count = 1;
            } else if (nums[i] == m) {
                count++;
            } else {
                count--;
            }
        }
        return m;
    }
}

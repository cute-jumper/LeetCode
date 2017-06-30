public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            nums[index++] = nums[i];
        }
        return index;
    }
}

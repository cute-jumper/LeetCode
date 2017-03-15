public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int lastIndex = nums.length - 1;
        while (lastIndex >= 0 && nums[lastIndex] == val) {
            lastIndex--;
        }
        int index = 0;
        while (index < lastIndex) {
            if (nums[index] == val) {
                nums[index] = nums[lastIndex];
                nums[lastIndex] = val;
                while (lastIndex > index && nums[lastIndex] == val) {
                    lastIndex--;
                }
            }
            index++;
        }
        return lastIndex + 1;
    }
}

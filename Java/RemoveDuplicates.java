public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentIndex = 0;
        int startIndex = 0;
        do {
            nums[currentIndex++] = nums[startIndex];
            int nextIndex = startIndex + 1;
            while (nextIndex < nums.length && nums[nextIndex] == nums[startIndex]) {
                nextIndex++;
            }
            startIndex = nextIndex;
        } while (startIndex < nums.length);
        return currentIndex;
    }
}

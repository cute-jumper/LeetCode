public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        int counter = 0;
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prev) {
                counter++;
                if (counter <= 2) {
                    nums[index] = prev;
                    index++;
                }
            } else {
                prev = nums[i];
                counter = 1;
                nums[index] = prev;
                index++;
            }
        }
        return index;
    }
}

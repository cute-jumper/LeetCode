public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) count = 1;
            else count++;
            if (count < 3) nums[index++] = nums[i];
        }
        return index;
    }
}

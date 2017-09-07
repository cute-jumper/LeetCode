public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int size = 0;
            for (int j = i; nums[j] >= 0; size++) {
                int tmp = nums[j];
                nums[j] = -1;
                j = tmp;
            }
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}

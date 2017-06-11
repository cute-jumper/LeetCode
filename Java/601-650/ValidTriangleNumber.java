public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int s = nums[i] + nums[j];
                int index = Arrays.binarySearch(nums, s);
                if (index < 0) index = -index - 2;
                else {
                    while (nums[index] == s && index > j) index--;
                }
                if (index > j) total += index - j;
            }
        }
        return total;
    }
}

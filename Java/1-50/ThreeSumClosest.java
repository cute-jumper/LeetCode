public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int s = nums[low] + nums[high] + nums[i];
               	int diff = s - target;
                int absDiff = Math.abs(diff);
                if (diff > 0) high--;
                else low++;
                if (absDiff < minDiff) {
                    minDiff = absDiff;
                    sum = s;
                }
            }
        }
        return sum;
    }
}

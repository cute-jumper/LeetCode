public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2 && closest != 0; i++) {
            closest = twoSumClosest(target - nums[i], nums, i + 1, closest);
        }
        return target + closest;
    }

    public int twoSumClosest(int sum, int[] nums, int start, int closest) {
        int low = start, high = nums.length - 1;
        while (low < high) {
            int target = nums[low] + nums[high];
            int diff = target - sum;
            if (diff == 0) {
                return diff;
            }
            if (Math.abs(diff) < Math.abs(closest)) {
                closest = diff;
            }
            if (diff < 0) {
                low++;
            } else {
                high--;
            }
        }
        return closest;
    }
}

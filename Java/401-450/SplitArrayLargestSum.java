public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int maxVal = 0;
        int sum = 0;
        for (int i : nums) {
            maxVal = Math.max(maxVal, i);
            sum += i;
        }
        int low = maxVal;
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = trySplit(nums, mid);
            if (count > m) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public int trySplit(int[] nums, int v) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > v) {
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return count;
    }
}

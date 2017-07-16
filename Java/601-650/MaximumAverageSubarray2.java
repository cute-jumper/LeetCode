public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while (max - min > 1e-5) {
            double mid = (max + min) / 2.;
            double[] s = new double[nums.length + 1];
            int m = 0;
            boolean flag = true;
            for (int i = 0; i < nums.length && flag; i++) {
                s[i + 1] = s[i] + nums[i] - mid;
                if (i + 1 > k && s[i + 1 - k] < s[m]) m = i + 1 - k;
                if (i + 1 >= k && s[i + 1] >= s[m]) {
                    min = mid;
                    flag = false;
                }
            }
            if (flag) max = mid;
        }
        return (max + min) / 2;
    }
}

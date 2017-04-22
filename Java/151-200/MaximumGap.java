public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int maxVal = nums[0], minVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxVal = Math.max(nums[i], maxVal);
            minVal = Math.min(minVal, nums[i]);
        }
        if (maxVal == minVal) return 0;
        int gapSize = (maxVal - minVal) / (nums.length - 1) + 1;
        int[][] segs = new int[nums.length][2];
        for (int i = 0; i < segs.length; i++) {
            segs[i][0] = Integer.MAX_VALUE;
            segs[i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - minVal) / gapSize;
            if (segs[index][0] > nums[i]) segs[index][0] = nums[i];
            if (segs[index][1] < nums[i]) segs[index][1] = nums[i];
        }
        int maxGap = gapSize - 1;
        int prevMax = segs[0][1];
        for (int i = 1; i < segs.length; i++) {
            if (segs[i][0] != Integer.MAX_VALUE) {
                maxGap = Math.max(maxGap, segs[i][0] - prevMax);
                prevMax = segs[i][1];
            }
        }
        return maxGap;
    }
}

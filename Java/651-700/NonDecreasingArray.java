class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int i = 0;
        for (; i + 1 < nums.length; i++) {
            if (nums[i] >  nums[i + 1]) break;
        }
        if (i == nums.length - 1) return true;
        int j = nums.length - 1;
        for (; j > 0; j--) {
            if (nums[j - 1] > nums[j]) break;
        }
        return j == i + 1 && (i == 0 || j == nums.length - 1 || nums[i - 1] <= nums[j] || nums[i] <= nums[j + 1]);
    }
}

class PathSum4 {
    public int pathSum(int[] nums) {
        int s = 0;
        int[] vals = new int[65];
        for (int i = nums.length - 1; i >= 0; i--) {
            int d = nums[i] / 100, p = (nums[i] / 10) % 10, v = nums[i] % 10;
            int index = (1 << (d  - 1)) + p - 1;
            vals[index] = vals[index * 2] + vals[index * 2 + 1];
            if (vals[index] == 0) vals[index] = 1;
            s += v * vals[index];
        }
        return s;
    }
}

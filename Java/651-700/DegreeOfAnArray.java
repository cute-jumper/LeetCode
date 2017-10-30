class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, int[]> range = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (!range.containsKey(nums[i])) range.put(nums[i], new int[] { i, i });
            else range.get(nums[i])[1] = i;
            max = Math.max(max, map.get(nums[i]));
        }
        int min = nums.length;
        for (int i : map.keySet()) {
            if (map.get(i) == max) min = Math.min(min, range.get(i)[1] - range.get(i)[0] + 1);
        }
        return min;
    }
}

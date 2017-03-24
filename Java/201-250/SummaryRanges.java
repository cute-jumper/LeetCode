public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == i - 1)
                    res.add(nums[start] + "");
                else
                    res.add(nums[start] + "->" + nums[i - 1]);
                start = i;
            }
        }
        return res;
    }
}

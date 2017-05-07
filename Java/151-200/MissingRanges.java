public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == lower) {
                if (nums[i] == Integer.MAX_VALUE) return res;
                lower++;
            } else if (nums[i] > lower) {
                if (nums[i] - lower == 1) {
                    res.add(lower + "");
                } else {
                    res.add(lower + "->" + (nums[i] - 1));
                }
                if (nums[i] == Integer.MAX_VALUE) return res;
                lower = nums[i] +  1;
            } else {
                continue;
            }
        }
        if (lower == upper) res.add(lower + "");
        else if (lower < upper) res.add(lower + "->" + upper);
        return res;
    }
}

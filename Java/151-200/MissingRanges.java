public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for (int i : nums) {
            if (i == next) next++;
            else if (i > next) {
                res.add(getRange(next, i - 1));;
                next = i + 1;
            }
            if (i == upper) return res;
        }
        if (upper >= next) res.add(getRange(next, upper));
        return res;
    }
    String getRange(int low, int high) {
        if (high == low) return low + "";
        else return low + "->" + high;
    }
}

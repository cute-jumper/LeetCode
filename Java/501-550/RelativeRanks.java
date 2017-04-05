public class RelativeRanks {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
        @Override
        public int compareTo(Pair that) {
            return that.val - this.val;
        }
    }
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < pairs.length; i++) {
            int index = pairs[i].index;
            if (i == 0) res[index] = "Gold Medal";
            else if (i == 1) res[index] = "Silver Medal";
            else if (i == 2) res[index] = "Bronze Medal";
            else res[index] = i + 1 + "";
        }
        return res;
    }
}

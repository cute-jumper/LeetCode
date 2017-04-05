public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) dups.add(i);
        }
        if (k == 0) return dups.size();
        int res = 0;
        for (int i : set) {
            if (set.contains(i + k)) res++;
        }
        return res;
    }
}

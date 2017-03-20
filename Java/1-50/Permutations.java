public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return genPermutations(nums, new boolean[nums.length], new ArrayList<>());
    }
    public List<List<Integer>> genPermutations(int[] nums, boolean[] flags, List<Integer> prefix) {
        List<List<Integer>> res = new ArrayList<>();
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<Integer>(prefix));
            return res;
        }
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) continue;
            flags[i] = true;
            prefix.add(nums[i]);
            List<List<Integer>> perms = genPermutations(nums, flags, prefix);
            res.addAll(perms);
            flags[i] = false;
            prefix.remove(prefix.size() - 1);
        }
        return res;
    }
}

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        return genPermutations(nums, new boolean[nums.length], new ArrayList<Integer>());
    }
    public List<List<Integer>> genPermutations(int[] nums, boolean[] flags, ArrayList<Integer> prefix) {
        List<List<Integer>> res = new ArrayList<>();
        if (prefix.size() == nums.length) {
            res.add(new ArrayList<Integer>(prefix));
            return res;
        }
        int prev = nums[0] - 1;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) continue;
            if (nums[i] == prev) continue;
            flags[i] = true;
            prefix.add(nums[i]);
            prev = nums[i];
            List<List<Integer>> perms = genPermutations(nums, flags, prefix);
            res.addAll(perms);
            flags[i] = false;
            prefix.remove(prefix.size() - 1);
        }
        return res;
    }
}

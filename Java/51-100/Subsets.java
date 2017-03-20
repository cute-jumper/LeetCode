public class  {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            res.addAll(genSubsets(nums, 0, i));
        return res;
    }
    public List<List<Integer>> genSubsets(int[] nums, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        for (int i = start; i < nums.length; i++) {
            List<List<Integer>> subRes = genSubsets(nums, i + 1, k - 1);
            for (List<Integer> r: subRes) {
                List<Integer> rs = new ArrayList<>();
                rs.add(nums[i]);
                rs.addAll(r);
                res.add(rs);
            }
        }
        return res;
    }
}

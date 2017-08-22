public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length], nums.length);
        return res;
    }
    void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] visited, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0, prev = nums[0] - 1; i < nums.length; i++) {
            if (!visited[i] && nums[i] != prev) {
                visited[i] = true;
                curr.add(nums[i]);
                dfs(res, curr, nums, visited, remain - 1);
                curr.remove(curr.size() - 1);
                visited[i] = false;
                prev = nums[i];
            }
        }
    }
}

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new ArrayList<>(), nums, new boolean[nums.length], nums.length);
        return res;
    }
    void permute(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] visited, int remain) {
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                permute(res, curr, nums, visited, remain - 1);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}

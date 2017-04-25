/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);
        return dfs(root, prefixSums, 0, sum);
    }
    public int dfs(TreeNode root, Map<Integer, Integer> prefixSums, int sum, int target) {
        if (root == null) return 0;
        sum += root.val;
        int res = 0;
        if (prefixSums.containsKey(sum - target)) {
            res += prefixSums.get(sum - target);
        }
        if (prefixSums.containsKey(sum)) prefixSums.put(sum, prefixSums.get(sum) + 1);
        else prefixSums.put(sum, 1);
        res += dfs(root.left, prefixSums, sum, target);
        res += dfs(root.right, prefixSums, sum, target);
        prefixSums.put(sum, prefixSums.get(sum) - 1);
        return res;
    }
}

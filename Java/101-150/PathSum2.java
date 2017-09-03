/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, new ArrayList<>(), root, sum);
        return res;
    }
    void pathSum(List<List<Integer>> res, List<Integer> curr, TreeNode root, int sum) {
        if (root == null) return;
        curr.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) res.add(new ArrayList<>(curr));
        if (root.left != null) pathSum(res, curr, root.left, sum);
        if (root.right != null) pathSum(res, curr, root.right, sum);
        curr.remove(curr.size() - 1);
    }
}

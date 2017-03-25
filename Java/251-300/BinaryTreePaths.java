/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, "" + root.val, root);
        return res;
    }
    public void dfs(List<String> res, String prefix, TreeNode node) {
        if (node.left == null && node.right == null) {
            res.add(prefix);
            return;
        }
        if (node.left != null) dfs(res, prefix + "->" + node.left.val, node.left);
        if (node.right != null) dfs(res, prefix + "->" + node.right.val, node.right);
    }
}

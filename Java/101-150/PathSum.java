/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumRecur(root, sum, 0);
    }
    public boolean hasPathSumRecur(TreeNode root, int sum, int current) {
        if (root == null) return sum == current;
        current += root.val;
        if (root.left == null) return hasPathSumRecur(root.right, sum, current);
        if (root.right == null) return hasPathSumRecur(root.left, sum, current);
        return hasPathSumRecur(root.left, sum, current) ||
            hasPathSumRecur(root.right, sum, current);
    }
}

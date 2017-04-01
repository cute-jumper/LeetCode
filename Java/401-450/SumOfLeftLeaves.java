/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, false);
    }
    public int getSum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == root.right && root.left == null) {
            return isLeft ? root.val : 0;
        }
        return getSum(root.left, true) + getSum(root.right, false);
    }
}

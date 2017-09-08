/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SecondMinimumNodeInBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }
    int helper(TreeNode root, int val) {
        if (root == null) return - 1;
        if (root.val > val) return root.val;
        int left = helper(root.left, val);
        int right = helper(root.right, val);
        if (left == -1 || right == -1) return Math.max(left, right);
        return Math.min(left, right);
    }
}

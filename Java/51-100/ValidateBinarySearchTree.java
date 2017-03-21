/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return root == null || validBST(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    public boolean validBST(TreeNode root, long minValue, long maxValue) {
        return root == null || root.val > minValue && root.val < maxValue &&
            validBST(root.left, minValue, root.val) &&
            validBST(root.right, root.val, maxValue);
    }
}

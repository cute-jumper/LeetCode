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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left) || prev != null && prev.val >= root.val) return false;
        prev = root;
        return isValidBST(root.right);
    }
}

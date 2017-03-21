/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumRoot(root, 0);
    }
    public int sumRoot(TreeNode root, int prev) {
        if (root == null) return prev;
        prev *= 10;
        prev += root.val;
        if (root.left == null) return sumRoot(root.right, prev);
        if (root.right == null) return sumRoot(root.left, prev);
        return sumRoot(root.left, prev) + sumRoot(root.right, prev);
    }
}

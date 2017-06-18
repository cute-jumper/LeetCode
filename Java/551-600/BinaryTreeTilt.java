/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return tilt;
    }
    int traverse(TreeNode node) {
        if (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        tilt += Math.abs(left - right);
        return node.val + left + right;
    }
}

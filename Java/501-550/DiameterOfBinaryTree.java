/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getDiameter(root);
        return diameter;
    }
    public int getDiameter(TreeNode root) {
        if (root == null) return -1;
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        diameter = Math.max(diameter, left + right + 2);
        return Math.max(left, right) + 1;
    }
}

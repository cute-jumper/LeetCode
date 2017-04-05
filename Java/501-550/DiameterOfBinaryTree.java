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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return getDiameter(root)[0] - 1;
    }
    public int[] getDiameter(TreeNode root) {
        if (root == null) return new int[] { 0, 0 };
        int[] left = getDiameter(root.left);
        int[] right = getDiameter(root.right);
        int diameter = left[1] + right[1] + 1;
        return new int[] { Math.max(diameter, Math.max(left[0], right[0])),
                           1 + Math.max(left[1], right[1])};
    }
}

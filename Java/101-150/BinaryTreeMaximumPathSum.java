/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        return maxSum(root)[0];
    }
    public int[] maxSum(TreeNode root) {
        if (root == null) return new int[] {Integer.MIN_VALUE, 0};
        int[] left = maxSum(root.left);
        int[] right = maxSum(root.right);
        return new int[] {Math.max(Math.max(left[0], right[0]), Math.max(left[1], 0) + Math.max(right[1], 0) + root.val),
                          Math.max(Math.max(left[1], right[1]), 0) + root.val};
    }
}

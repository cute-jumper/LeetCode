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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        getSum(root);
        return max;
    }
    int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getSum(root.left)), right = Math.max(0, getSum(root.right));
        max = Math.max(max, left + root.val + right);
        return root.val + Math.max(left, right);
    }
}

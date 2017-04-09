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
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        getChildSums(res, root);
        return res[0];
    }
    public int[] getChildSums(int[] res, TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = getChildSums(res, root.left);
        int leftMax = Math.max(Math.max(left[0], left[1]), 0);
        int[] right = getChildSums(res, root.right);
        int rightMax = Math.max(Math.max(right[0], right[1]), 0);
        res[0] = Math.max(res[0], leftMax + root.val + rightMax);
        return new int[] { root.val + leftMax, root.val + rightMax };
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    int helper(TreeNode root) {
        if (root == null) return -1;
        int left = helper(root.left), right = helper(root.right);
        if (left >= 0 && root.val == root.left.val) left++;
        else left = 0;
        if (right >= 0 && root.val == root.right.val) right++;
        else right = 0;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}

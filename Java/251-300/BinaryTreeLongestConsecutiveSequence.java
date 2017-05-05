/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequence {
    int maxLen = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        getLongest(root, root.val - 2, 0);
        return maxLen;
    }
    public void getLongest(TreeNode node, int val, int len) {
        if (node == null) return;
        if (node.val == val + 1) {
            len = len + 1;
            maxLen = Math.max(maxLen, len);
        } else {
            len = 1;
        }
        getLongest(node.left, node.val, len);
        getLongest(node.right, node.val, len);
    }
}

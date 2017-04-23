/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    public int depth(TreeNode node) {
        if (node == null) return -1;
        return 1 + depth(node.left);
    }
    public int countNodes(TreeNode root) {
        int count = 0;
        while (root != null) {
            int d = depth(root);
            int rd = depth(root.right);
            if (rd == d - 1) {
                count += (1 << d);
                root = root.right;
            } else {
                count += (1 << (d - 1));
                root = root.left;
            }
        }
        return count;
    }
}

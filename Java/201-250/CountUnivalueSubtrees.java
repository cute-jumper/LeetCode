/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountUnivalueSubtrees {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        traverse(root);
        return count;
    }
    boolean traverse(TreeNode node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean left = traverse(node.left);
        boolean right = traverse(node.right);
        if (left && right) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            count++;
            return true;
        }
        return false;
    }
}

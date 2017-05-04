/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root;
        TreeNode right = null;
        TreeNode prev = null;
        while (node != null) {
            TreeNode nextRight = node.right;
            TreeNode next = node.left;
            node.left = right;
            node.right = prev;
            right = nextRight;
            prev = node;
            node = next;
        }
        return prev;
    }
}

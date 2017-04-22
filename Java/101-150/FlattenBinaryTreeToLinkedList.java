/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        for (; root != null; root = root.right) {
            if (root.left == null) continue;
            TreeNode node = root.left;
            while (node.right != null) node = node.right;
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode parent = null;
        while (node != null && node.val != key) {
            parent = node;
            if (node.val < key) node = node.right;
            else node = node.left;
        }
        if (parent == null) return deleteRoot(root);
        if (parent.left != null && parent.left.val == node.val) {
            parent.left = deleteRoot(node);
        } else {
            parent.right = deleteRoot(node);
        }
        return root;
    }
    public TreeNode deleteRoot(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode node = root.left;
        TreeNode parent = root;
        if (node.right == null) {
            root.val = node.val;
            parent.left = deleteRoot(node);
        } else {
            while (node.right != null) {
                parent = node;
                node = node.right;
            }
            root.val = node.val;
            parent.right = deleteRoot(node);
        }
        return root;
    }
}

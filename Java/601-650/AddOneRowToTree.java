/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        traverse(root, v, d, 1);
        return root;
    }
    void traverse(TreeNode root, int v, int d, int depth) {
        if (root == null) return;
        if (depth == d - 1) {
            TreeNode left = new TreeNode(v);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(v);
            right.right = root.right;
            root.right = right;
            return;
        }
        traverse(root.left, v, d, depth + 1);
        traverse(root.right, v, d, depth + 1);
    }
}

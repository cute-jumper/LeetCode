/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        int minValue = Math.min(p.val, q.val), maxValue = Math.max(p.val, q.val);
        if (root.val < minValue) return lowestCommonAncestor(root.right, p, q);
        if (root.val > maxValue) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return sameTree(s, t) || s != null && (isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    boolean sameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return n1.val == n2.val && sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBST {
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        TreeNode[] res = new TreeNode[2];
        inOrder(res, root);
        int tmp = res[0].val;
        res[0].val = res[1].val;
        res[1].val = tmp;
    }
    public void inOrder(TreeNode[] res, TreeNode root) {
        if (root == null) return;
        inOrder(res, root.left);
        if (prev != null && prev.val > root.val) {
            res[1] = root;
            if (res[0] == null) res[0] = prev;
            else return;
        }
        prev = root;
        inOrder(res, root.right);
    }
}

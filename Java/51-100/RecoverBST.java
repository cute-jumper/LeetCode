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
    public void recoverTree(TreeNode root) {
        TreeNode[] res = new TreeNode[2];
        TreeNode[] prev = new TreeNode[1];
        inOrder(res, root, prev);
        int tmp = res[0].val;
        res[0].val = res[1].val;
        res[1].val = tmp;
    }
    public void inOrder(TreeNode[] res, TreeNode root, TreeNode[] prev) {
        if (root == null) return;
        inOrder(res, root.left, prev);
        if (res[0] != null) {
            if (prev[0].val > root.val) {
                res[1] = root;
            }
            prev[0] = root;
            inOrder(res, root.right, prev);
        } else {
            if (prev[0] != null && prev[0].val > root.val) {
                res[0] = prev[0];
                res[1] = root;
            }
            prev[0] = root;
            inOrder(res, root.right, prev);
        }
    }
}

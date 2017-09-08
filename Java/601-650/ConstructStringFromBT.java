/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructStringFromBT {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return t.val + "";
        String s = t.val + "(" + tree2str(t.left) + ")";
        return t.right == null ? s : s + "(" + tree2str(t.right) + ")";
    }
}

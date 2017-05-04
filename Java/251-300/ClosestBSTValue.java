/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = target < root.val ? root.left : root.right;
        if (kid == null) return root.val;
        int v = closestValue(kid, target);
        if (Math.abs(root.val - target) < Math.abs(v - target)) return root.val;
        else return v;
    }
}

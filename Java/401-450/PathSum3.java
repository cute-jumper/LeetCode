/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        return getPathCount(root, sum, sum, false);
    }
    public int getPathCount(TreeNode root, int sum, int original, boolean mustPick) {
        if (root == null) return 0;
        int res = getPathCount(root.left, sum - root.val, original, true) +
            getPathCount(root.right, sum - root.val, original, true) +
            (root.val == sum ? 1 : 0);
        if (!mustPick) {
            res += getPathCount(root.left, original, original, false) +
                getPathCount(root.right, original, original, false);
        }
        return res;
    }
}

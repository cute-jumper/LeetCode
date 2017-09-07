/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindBottomLeftTreeValue {
    int maxLevel = -1;
    int left = -1;
    public int findBottomLeftValue(TreeNode root) {
        maxLevel = left = -1;
        getBottomLeft(root, 0);
        return left;
    }
    public void getBottomLeft(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxLevel) {
            maxLevel = depth;
            left = root.val;
        }
        getBottomLeft(root.left, depth + 1);
        getBottomLeft(root.right, depth + 1);
    }
}

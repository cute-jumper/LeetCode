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
    public int findBottomLeftValue(TreeNode root) {
        int[] res = getBottomLeft(root, 0);
        return res[0];
    }
    public int[] getBottomLeft(TreeNode root, int depth) {
        if (root.left == null && root.right == null)
            return new int[] { root.val, depth };
        if (root.left == null) return getBottomLeft(root.right, depth + 1);
        else if (root.right == null) return getBottomLeft(root.left, depth + 1);
        int[] left = getBottomLeft(root.left, depth + 1);
        int[] right = getBottomLeft(root.right, depth + 1);
        if (left[1] >= right[1]) return left;
        else return right;
    }
}

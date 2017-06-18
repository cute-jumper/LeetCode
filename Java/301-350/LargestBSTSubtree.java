/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LargestBSTSubtree {
    int max;
    public int largestBSTSubtree(TreeNode root) {
        traverse(root);
        return max;
    }
    int[] traverse(TreeNode root) {
        if (root == null) return new int[] { 0, 0, 0 };
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        if (left[0] == -1 || right[0] == -1 ||
            left[0] != 0 && left[2] >= root.val ||
            right[0] != 0 && right[1] <= root.val)
            return new int[] { -1, 0, 0 };
        int size = left[0] + right[0] + 1;
        max = Math.max(max, size);
        int lower = left[0] == 0 ? root.val : left[1];
        int upper = right[0] == 0 ? root.val : right[2];
        return new int[] { size, lower, upper };
    }
}

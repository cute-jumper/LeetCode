/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructInoderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    public TreeNode getTree(int[] inorder, int low, int high, int[] postorder, int end) {
        if (low > high) return null;
        TreeNode root = new TreeNode(postorder[end]);
        int i;
        for (i = low; i <= high; i++) {
            if (inorder[i] == root.val) break;
        }
        if (i > high) return null;
        root.left = getTree(inorder, low, i - 1, postorder, end - (high - i) - 1);
        root.right = getTree(inorder, i + 1, high, postorder, end - 1);
        return root;
    }
}

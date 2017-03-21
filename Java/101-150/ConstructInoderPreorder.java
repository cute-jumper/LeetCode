/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
    public TreeNode getTree(int[] preorder, int start, int[] inorder, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for (i = low; i <= high; i++) {
            if (inorder[i] == root.val) break;
        }
        if (i > high) return null;
        root.left = getTree(preorder, start + 1, inorder, low, i - 1);
        root.right = getTree(preorder, start + i - low + 1, inorder, i + 1, high);
        return root;
    }
}

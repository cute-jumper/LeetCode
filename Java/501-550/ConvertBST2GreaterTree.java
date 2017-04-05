/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertBST2GreaterTree {
    public TreeNode convertBST(TreeNode root) {
        greaterSum(root, 0);
        return root;
    }
    public int greaterSum(TreeNode root, int parentSum) {
        if (root == null) return 0;
        root.val += subtreeSum(root.right) + parentSum;
        greaterSum(root.right, parentSum);
        greaterSum(root.left, root.val);
        return root.val;
    }
    public int subtreeSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + subtreeSum(root.left) + subtreeSum(root.right);
    }
}

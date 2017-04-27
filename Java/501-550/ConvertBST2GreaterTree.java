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
        int val = root.val;
        int rightVal = greaterSum(root.right, parentSum);
        root.val += rightVal + parentSum;
        return val + rightVal + greaterSum(root.left, root.val);
    }
}

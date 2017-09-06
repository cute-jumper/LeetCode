/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    void helper(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);
        helper(res, root.right, depth + 1);
        helper(res, root.left, depth + 1);
    }
}

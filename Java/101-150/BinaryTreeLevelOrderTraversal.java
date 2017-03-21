/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        if (root != null) current.add(root);
        while (current.size() > 0) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : current) {
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(level);
            current = next;
        }
        return res;
    }
}

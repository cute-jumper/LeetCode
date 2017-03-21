/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        if (root != null) current.add(root);
        while (current.size() > 0) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (TreeNode node : current) {
                level.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(level);
            current = next;
        }
        Collections.reverse(res);
        return res;
    }
}

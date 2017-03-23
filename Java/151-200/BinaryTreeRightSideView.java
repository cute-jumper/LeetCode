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
        List<TreeNode> current = new ArrayList<>();
        if (root != null) current.add(root);
        while (!current.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < current.size(); i++) {
                TreeNode n = current.get(i);
                if (n.right != null) next.add(n.right);
                if (n.left != null) next.add(n.left);
            }
            res.add(current.get(0).val);
            current = next;
        }
        return res;
    }
}

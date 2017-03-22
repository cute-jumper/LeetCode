/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null) {
            res.add(p.val);
            stack.addFirst(p);
            p = p.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    res.add(node.val);
                    stack.addFirst(node);
                    node = node.left;
                }
            }
        }
        return res;
    }
}

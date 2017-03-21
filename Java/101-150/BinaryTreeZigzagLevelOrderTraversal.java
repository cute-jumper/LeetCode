/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> current = new ArrayDeque<>();
        if (root != null) current.add(root);
        boolean l2r = true;
        while (!current.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Deque<TreeNode> next = new ArrayDeque<>();
            while (!current.isEmpty()) {
                TreeNode node = null;
                if (l2r) {
                    node = current.pollFirst();
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                } else {
                    node = current.pollLast();
                    if (node.right != null) next.addFirst(node.right);
                    if (node.left != null) next.addFirst(node.left);
                }
                level.add(node.val);
            }
            res.add(level);
            l2r = !l2r;
            current = next;
        }
        return res;
    }
}

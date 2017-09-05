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
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        boolean l2r = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode node = null;
                if (l2r) {
                    node = queue.poll();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                } else {
                    node = queue.pollLast();
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
                level.add(node.val);
            }
            res.add(level);
            l2r = !l2r;
        }
        return res;
    }
}

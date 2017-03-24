/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null) {
            stack.offerFirst(node);
            node = node.left;
        }
        while (k != 0) {
            node = stack.pollFirst();
            k--;
            if (k == 0) return node.val;
            node = node.right;
            while (node != null) {
                stack.offerFirst(node);
                node = node.left;
            }
        }
        return 0;
    }
}

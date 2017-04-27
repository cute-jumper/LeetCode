/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinimumAbsDiffInBST {
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root, prev = null;
        int minDiff = Integer.MAX_VALUE;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (prev != null) {
                    minDiff = Math.min(minDiff, node.val - prev.val);
                }
                prev = node;
                node = node.right;
            }
        }
        return minDiff;
    }
}

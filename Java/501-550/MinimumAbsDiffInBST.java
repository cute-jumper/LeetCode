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
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        boolean init = false;
        int prev = 0;
        int minDiff = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (!init) {
                init = true;
            } else {
                minDiff = Math.min(minDiff, node.val - prev);
            }
            prev = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return minDiff;
    }
}

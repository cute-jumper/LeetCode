/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBSTValue2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (res.size() < k) res.offer(node.val);
                else {
                    double diff1 = Math.abs(node.val - target);
                    double diff2 = Math.abs(res.peek() - target);
                    if (diff1 < diff2) {
                        res.poll();
                        res.offer(node.val);
                    } else {
                        break;
                    }
                }
                node = node.right;
            }
        }
        return res;
    }
}

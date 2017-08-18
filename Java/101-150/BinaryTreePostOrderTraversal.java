/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                while (!stack.isEmpty() && stack.peek().right == p) {
                    p = stack.pop();
                    res.add(p.val);
                }
                if (!stack.isEmpty()) p = stack.peek().right;
                else break;
            }
        }
        return res;
    }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     PostOrderIterator it = new PostOrderIterator(root);
    //     while (it.hasNext()) res.add(it.next().val);
    //     return res;
    // }
    // static class PostOrderIterator {
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode curr = null;
    //     PostOrderIterator(TreeNode root) {
    //         while (root != null) {
    //             stack.push(root);
    //             root = root.left;
    //         }
    //     }
    //     boolean hasNext() {
    //         return !stack.isEmpty();
    //     }
    //     TreeNode next() {
    //         if (stack.peek().right != curr) {
    //             curr = stack.peek().right;
    //             while (curr != null) {
    //                 stack.push(curr);
    //                 curr = curr.left;
    //             }
    //             return next();
    //         }
    //         curr = stack.pop();
    //         return curr;
    //     }
    // }
}

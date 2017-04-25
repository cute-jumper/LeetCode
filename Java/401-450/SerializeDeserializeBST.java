/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                sb.append(node.val + ",");
                node = node.left;
            } else {
                node = stack.pop().right;
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] vals = data.split(",");
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        stack.push(root);
        for (int i = 1; i < vals.length; i++) {
            TreeNode node = stack.peek();
            int v = Integer.parseInt(vals[i]);
            if (v < node.val) {
                node.left = new TreeNode(v);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val < v) {
                    node = stack.pop();
                }
                node.right = new TreeNode(v);
                stack.push(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

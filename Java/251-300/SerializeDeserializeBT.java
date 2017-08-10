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
        StringBuilder sb = new StringBuilder();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : curr) {
                if (sb.length() > 0) sb.append(",");
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    next.add(node.left);
                    next.add(node.right);
                }
            }
            curr = next;
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        TreeNode root = getTreeNode(parts[0]);
        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        int index = 1;
        while (!curr.isEmpty() && index < parts.length) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : curr) {
                if (node == null) continue;
                node.left = getTreeNode(parts[index]);
                index++;
                node.right = getTreeNode(parts[index]);
                index++;
                next.add(node.left);
                next.add(node.right);
            }
            curr = next;
        }
        return root;
    }
    public TreeNode getTreeNode(String s) {
        return s.equals("null") ? null : new TreeNode(Integer.parseInt(s));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     StringBuilder sb = new StringBuilder();
    //     preorder(sb, root);
    //     return sb.toString();
    // }
    // public void preorder(StringBuilder sb, TreeNode root) {
    //     if (root == null) sb.append("null,");
    //     else {
    //         sb.append(root.val + ",");
    //         preorder(sb, root.left);
    //         preorder(sb, root.right);
    //     }
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     String[] ps = data.split(",");
    //     Queue<String> queue = new ArrayDeque<>();
    //     for (String p : ps) queue.offer(p);
    //     return toTree(queue);
    // }
    // TreeNode toTree(Queue<String> queue) {
    //     if (queue.isEmpty()) return null;
    //     String s = queue.poll();
    //     if (s.equals("null")) return null;
    //     TreeNode node = new TreeNode(Integer.parseInt(s));
    //     node.left = toTree(queue);
    //     node.right=  toTree(queue);
    //     return node;
    // }

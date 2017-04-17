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

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> current = new ArrayList<>();
        if (root != null) current.add(root);
        while (current.size() > 0) {
            TreeLinkNode prev = null;
            List<TreeLinkNode> next = new ArrayList<>();
            for (TreeLinkNode node : current) {
                if (node.right != null) next.add(node.right);
                if (node.left != null) next.add(node.left);
                node.next = prev;
                prev = node;
            }
            current = next;
        }
    }
}

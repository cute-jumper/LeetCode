/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulateNexRightPointers {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        root.next = null;
        while (root.left != null) {
            TreeLinkNode p = root;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) {
                    p.right.next = p.next.left;
                } else {
                    p.right.next = null;
                }
                p = p.next;
            }
            root = root.left;
        }
    }
}

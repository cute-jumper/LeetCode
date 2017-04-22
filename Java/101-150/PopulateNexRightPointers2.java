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
        if (root == null) return;
        root.next = null;
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        while (root != null) {
            while (root != null) {
                if (root.left != null) {
                    if (prev == null) head = root.left;
                    else prev.next = root.left;
                    prev = root.left;
                }
                if (root.right != null) {
                    if (prev == null) head = root.right;
                    else prev.next = root.right;
                    prev = root.right;
                }
                root = root.next;
            }
            root = head;
            head = null;
            prev = null;
        }
    }
}

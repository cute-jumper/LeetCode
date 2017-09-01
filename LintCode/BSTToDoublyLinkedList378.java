/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class BSTToDoublyLinkedList378 {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    DoublyListNode head, prev;
    public DoublyListNode bstToDoublyList(TreeNode root) {
        head = prev = null;
        convert(root);
        return head;
    }
    void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);
        DoublyListNode node = new DoublyListNode(root.val);
        if (prev == null) head = node;
        else {
            prev.next = node;
            node.prev = prev;
        }
        prev = node;
        convert(root.right);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode node = head;
        ListNode last = null;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        last = node;
        k %= len;
        if (k == 0) return head;
        node = head;
        for (int i = 0; i < len - k - 1; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        node.next = null;
        last.next = head;
        return newHead;
    }
}
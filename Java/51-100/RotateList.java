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
        ListNode node = head;
        int size = 1;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        k %= size;
        if (k == 0) return head;
        node.next = head;
        for (int i = 0; i < size - k; i++) node = node.next;
        head = node.next;
        node.next = null;
        return head;
    }
}

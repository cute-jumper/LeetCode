/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = reverseList(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null && p != null) {
            ListNode next1 = slow.next;
            slow.next = p;
            ListNode next2 = p.next;
            p.next = next1;
            slow = next1;
            p = next2;
        }

    }
    public ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode prev = null;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = vhead;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode prevEnd = p;
        ListNode prev = null;
        p = p.next;
        for (int i = m; i <= n; i++) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        prevEnd.next.next = p;
        prevEnd.next = prev;
        return vhead.next;
    }
}

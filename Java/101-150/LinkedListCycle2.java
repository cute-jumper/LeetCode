/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head;
        while (p != null && q != null) {
            p = p.next;
            q = q.next;
            if (q != null) q = q.next;
            else return null;
            if (p == q) {
                ListNode c = head;
                while (c != p) {
                    c = c.next;
                    p = p.next;
                }
                return c;
            }
        }
        return null;
    }
}

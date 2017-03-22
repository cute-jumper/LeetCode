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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode p = head;
        ListNode q = p.next;
        while (p != null && q != null) {
            p = p.next;
            q = q.next;
            if (q != null) q = q.next;
            if (p == q) return true;
        }
        return false;
    }
}

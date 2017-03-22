/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode end = head;
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        while (end.next != null) {
            ListNode next = end.next;
            if (next.val >= end.val) {
                end = next;
                continue;
            }
            ListNode prev = vhead;
            ListNode curr = vhead.next;
            while (prev != end && curr != null) {
                if (curr.val > next.val) break;
                prev = curr;
                curr = curr.next;
            }
            prev.next = next;
            end.next = next.next;
            next.next = curr;
        }
        return vhead.next;
    }
}

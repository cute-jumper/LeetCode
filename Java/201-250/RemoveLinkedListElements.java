/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = head;
        ListNode prev = vhead;
        while (p != null) {
            if (p.val == val) {
                prev.next = p.next;
            } else {
                prev = p;
            }
            p = p.next;
        }
        return vhead.next;
    }
}

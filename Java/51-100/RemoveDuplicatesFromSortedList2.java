/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode vhead = new ListNode(head.val - 1);
        vhead.next = head;
        ListNode saved = vhead;
        ListNode p = head.next;
        int prev = head.val;
        int counter = 1;
        while (p != null) {
            if (p.val != prev) {
                if (counter > 1) {
                    saved.next = p;
                    counter = 1;
                } else {
                    saved = saved.next;
                }
                prev = p.val;
            } else {
                counter++;
            }
            p = p.next;
        }
        if (counter > 1) saved.next = null;
        return vhead.next;
    }
}

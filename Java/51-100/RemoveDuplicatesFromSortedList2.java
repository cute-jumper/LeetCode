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
        ListNode node = vhead;
        ListNode p = head;
        while (p != null) {
            if (p.next != null && p.next.val == p.val) {
                while (p.next != null && p.next.val == p.val) p = p.next;
                p = p.next;
            } else {
                node.next = p;
                node = p;
                p = p.next;
            }
        }
        node.next = null;
        return vhead.next;
    }
}

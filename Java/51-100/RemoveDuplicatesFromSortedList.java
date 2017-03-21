/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode saved = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val != saved.val) {
                saved.next = p;
                saved = p;
            }
            p = p.next;
        }
        saved.next = null;
        return head;
    }
}

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
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode prev = vhead, curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                while (curr != null && curr.val == prev.next.val) curr = curr.next;
                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return vhead.next;
    }
}

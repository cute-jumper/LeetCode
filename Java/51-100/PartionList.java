/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode right = rightHead;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = p;
            } else {
                right.next = p;
                right = p;
            }
            p = p.next;
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead.next;
   }
}

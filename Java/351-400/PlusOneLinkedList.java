/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode node = vh, p = head;
        while (p != null) {
            if (p.val != 9) node = p;
            p = p.next;
        }
        node.val++;
        p = node.next;
        while (p != null) {
            p.val = 0;
            p = p.next;
        }
        if (vh.val == 0) return head;
        return vh;
    }
}

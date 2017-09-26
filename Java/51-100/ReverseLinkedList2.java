/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode node = vhead;
        for (int i = 1; i < m; i++) node = node.next;
        ListNode prev = null, curr = node.next;
        for (int i = m; i <= n; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node.next.next = curr;
        node.next = prev;
        return vhead.next;
    }
}

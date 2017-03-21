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
        if (m == n) return head;
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode p = vhead;
        while (m > 1) {
            p = p.next;
            m--;
            n--;
        }
        n -= m;
        ListNode low = p;
        p = p.next;
        ListNode high = p;
        System.out.println(low.val);
        System.out.println(high.val);
        ListNode prev = null;
        while (n >= 0) {
            ListNode node = p;
            p = p.next;
            node.next = prev;
            prev = node;
            n--;
        }
        low.next = prev;
        high.next = p;
        return vhead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vh = new ListNode(0);
        vh.next = head;
        ListNode node = vh;
        ListNode p = head;
        int k = 1;
        while (p.next != null) {
            p = p.next;
            if (k < n) k++;
            else {
                node = node.next;
            }
        }
        node.next = node.next.next;
        return vh.next;
    }
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode vhead = new ListNode(0);
    //     vhead.next = head;
    //     ListNode fast = vhead;
    //     for (int i = 0; i < n; i++) fast = fast.next;
    //     ListNode slow = vhead;
    //     while (fast.next != null) {
    //         fast = fast.next;
    //         slow = slow.next;
    //     }
    //     slow.next = slow.next.next;
    //     return vhead.next;
    // }
}

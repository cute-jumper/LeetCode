/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) return head;
            node = node.next;
        }
        node = reverseKGroup(node, k);
        for (int i = 0; i < k; i++) {
            ListNode next = head.next;
            head.next = node;
            node = head;
            head = next;
        }
        return node;
        // ListNode node = head;
        // int count = 0;
        // while (node != null) {
        //     count++;
        //     node = node.next;
        // }
        // node = head;
        // ListNode prev = null;
        // ListNode vhead = new ListNode(0);
        // vhead.next = head;
        // ListNode prevEnd = vhead;
        // for (int i = 0; i < count / k; i++) {
        //     for (int j = 0; j < k; j++) {
        //         ListNode next = node.next;
        //         node.next = prev;
        //         prev = node;
        //         node = next;
        //     }
        //     ListNode tail = prevEnd.next;
        //     prevEnd.next = prev;
        //     tail.next = node;
        //     prevEnd = tail;
        //     prev = null;
        // }
        // return vhead.next;
    }
}

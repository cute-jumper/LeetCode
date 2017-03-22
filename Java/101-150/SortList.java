/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode slow = a;
        ListNode fast = a;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode first = mergeSort(a);
        ListNode second = mergeSort(next);
        return merge(first, second);
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode vhead = new ListNode(0);
        ListNode p = vhead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                p = a;
                a = a.next;
            } else {
                p.next = b;
                p = b;
                b = b.next;
            }
        }
        if (a != null) p.next = a;
        if (b != null) p.next = b;
        return vhead.next;
    }
}

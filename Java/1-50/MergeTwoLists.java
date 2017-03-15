public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode vhead = new ListNode(0);
        ListNode curHead = vhead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curHead.next = p1;
                p1 = p1.next;
            } else {
                curHead.next = p2;
                p2 = p2.next;
            }
            curHead = curHead.next;
        }
        if (p1 != null) {
            curHead.next = p1;
        }
        if (p2 != null) {
            curHead.next = p2;
        }
        return vhead.next;
    }
}

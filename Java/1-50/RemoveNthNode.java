public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode curHead = vhead;
        ListNode curTail = vhead;
        int times = n;
        while (times != 0 && curTail.next != null) {
            curTail = curTail.next;
            times--;
        }
        if (times != 0) {
            return head.next;
        }
        while (curTail.next != null) {
            curTail = curTail.next;
            curHead = curHead.next;
        }
        curHead.next = curHead.next.next;
        return vhead.next;
    }
}

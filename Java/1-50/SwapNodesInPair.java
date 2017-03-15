public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode first = vhead;
        ListNode second = head;
        while (second != null && second.next != null) {
            ListNode last = second.next;
            first.next = last;
            second.next = last.next;
            last.next = second;
            first = second;
            second = first.next;
        }
        return vhead.next;
    }
}

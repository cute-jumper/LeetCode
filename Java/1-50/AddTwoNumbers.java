class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null || l2 != null) {
            int res = add;
            if (l1 != null) {
                res += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                res += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(res % 10);
            curr.next = node;
            curr = curr.next;
            add = res / 10;
        }
        if (add == 1) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}

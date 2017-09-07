/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        ListNode p = l1;
        while (p != null) {
            stack1.push(p);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            stack2.push(p);
            p = p.next;
        }
        int carry = 0;
        ListNode vh = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            carry += (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val);
            ListNode node = new ListNode(carry % 10);
            node.next = vh.next;
            vh.next = node;
            carry /= 10;
        }
        return vh.next;
    }
}

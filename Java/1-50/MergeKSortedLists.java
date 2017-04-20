/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(lists.length,
                                new Comparator<ListNode>() {
                                    @Override
                                    public int compare(ListNode a, ListNode b) {
                                        return a.val - b.val;
                                    }
                                });
        ListNode vhead = new ListNode(0);
        ListNode p = vhead;
        for (ListNode node : lists)
            if (node != null) pq.add(node);
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) pq.add(node.next);
        }
        return vhead.next;
    }
}

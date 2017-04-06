/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedLists {
    static class Pair {
        ListNode node;
        int index;
        public Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<Pair> pq =
            new PriorityQueue<>(lists.length,
                                new Comparator<Pair>() {
                                    @Override
                                    public int compare(Pair a, Pair b) {
                                        if (a.node.val < b.node.val) return -1;
                                        if (a.node.val > b.node.val) return 1;
                                        return 0;
                                    }
                                });
        ListNode[] heads = new ListNode[lists.length];
        for (int i = 0; i < heads.length; i++) {
            heads[i] = lists[i];
            if (heads[i] != null)
                pq.add(new Pair(heads[i], i));
        }
        ListNode vhead = new ListNode(0);
        ListNode mergeHead = vhead;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            mergeHead.next = p.node;
            mergeHead = p.node;
            if (heads[p.index].next != null) {
                heads[p.index] = heads[p.index].next;
                pq.add(new Pair(heads[p.index], p.index));
            }
        }
        return vhead.next;
    }
}

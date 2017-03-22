/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode copy = new RandomListNode(head.label);
        RandomListNode p1 = head;
        RandomListNode p2 = copy;
        Map<Integer, RandomListNode> added = new HashMap<>();
        added.put(copy.label, copy);
        while (p1.next != null) {
            p1 = p1.next;
            RandomListNode c = new RandomListNode(p1.label);
            p2.next = c;
            p2 = c;
            added.put(c.label, c);
        }
        p1 = head;
        p2 = copy;
        while (p1 != null) {
            if (p1.random != null) {
                p2.random = added.get(p1.random.label);
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return copy;
    }
}

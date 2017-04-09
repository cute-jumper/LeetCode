public class LRUCache {
    static class Node {
        int val;
        int key;
        Node next;
        Node prev;
    }
    Map<Integer, Node> cache = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeNode(node);
        insertAtHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            removeNode(node);
            insertAtHead(node);
            return;
        }
        if (cache.size() == size) {
            int oldKey = tail.prev.key;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            cache.remove(oldKey);
        }
        Node node = new Node();
        node.key = key;
        node.val = value;
        insertAtHead(node);
        cache.put(key, node);
    }
    public void insertAtHead(Node node) {
        Node next = head.next;
        next.prev = node;
        node.next = next;
        node.prev = head;
        head.next = node;
    }
    public void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

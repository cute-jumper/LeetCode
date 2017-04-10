public class LFUCache {

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;
        FNode parent;
        public Node(FNode parent) {
            this.parent = parent;
        }
    }

    static class FNode {
        int freq;
        Node head = new Node(this);
        Node tail = new Node(this);
        FNode prev;
        FNode next;
        int count;
        public FNode(int freq) {
            this.freq = freq;
            head.next = tail;
            tail.prev = head;
            count = 0;
        }
        public void addNodeToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.parent = this;
            count++;
        }
        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.parent = null;
            count--;
        }
    }

    int size;
    Map<Integer, Node> cache = new HashMap<>();
    FNode fhead = new FNode(Integer.MAX_VALUE);
    FNode ftail = new FNode(Integer.MIN_VALUE);

    public LFUCache(int capacity) {
        this.size = capacity;
        fhead.next = ftail;
        ftail.prev = fhead;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        FNode parent = node.parent;
        parent.removeNode(node);
        getPrevFNode(parent, parent.freq + 1).addNodeToHead(node);
        if (parent.count == 0) removeFNode(parent);
        return node.val;
    }

    public void put(int key, int value) {
        if (size == 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            FNode parent = node.parent;
            parent.removeNode(node);
            getPrevFNode(parent, parent.freq + 1).addNodeToHead(node);
            if (parent.count == 0) removeFNode(parent);
            return;
        }
        if (cache.size() == size) {
            FNode last = ftail.prev;
            Node node = last.tail.prev;
            last.removeNode(node);
            if (last.count == 0) {
                removeFNode(last);
            }
            cache.remove(node.key);
        }
        Node node = new Node(null);
        node.key = key;
        node.val = value;
        getPrevFNode(ftail, 1).addNodeToHead(node);
        cache.put(key, node);
    }
    public void removeFNode(FNode fNode) {
        fNode.prev.next = fNode.next;
        fNode.next.prev = fNode.prev;
    }
    public FNode getPrevFNode(FNode next, int freq) {
        FNode fNode = next.prev;
        if (next.prev.freq > freq) {
            fNode = new FNode(freq);
            fNode.next = next;
            fNode.prev = next.prev;
            next.prev = fNode;
            fNode.prev.next = fNode;
        }
        return fNode;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

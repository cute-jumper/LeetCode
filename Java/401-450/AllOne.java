public class AllOne {
    Map<String, Node> map = new HashMap<>();
    static class VNode {
        int val;
        VNode prev;
        VNode next;
        Node head;
        Node tail;
        int size;
        public VNode(int val) {
            this.val = val;
            head = new Node();
            head.parent = this;
            tail = new Node();
            tail.parent = this;
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        public void addNode(Node node) {
            node.parent = this;
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            size++;
        }
        public String getHeadKey() {
            return head.next.key;
        }
    }
    static class Node {
        String key;
        VNode parent;
        Node prev;
        Node next;
    }
    VNode vhead = new VNode(Integer.MAX_VALUE);
    VNode vtail = new VNode(Integer.MIN_VALUE);
    public VNode getSmallerVNode(VNode vnode) {
        if (vnode.next.val == vnode.val - 1) return vnode.next;
        VNode n = new VNode(vnode.val - 1);
        n.next = vnode.next;
        n.prev = vnode;
        vnode.next = n;
        n.next.prev = n;
        return n;
    }
    public VNode getGreaterVNode(VNode vnode) {
        if (vnode.prev.val == vnode.val + 1 || vnode == vtail && vnode.prev.val == 1) return vnode.prev;
        VNode n = new VNode(vnode == vtail ? 1 : vnode.val + 1);
        n.prev = vnode.prev;
        n.next = vnode;
        vnode.prev = n;
        n.prev.next = n;
        return n;
    }
    public void removeVNode(VNode vnode) {
        vnode.next.prev = vnode.prev;
        vnode.prev.next = vnode.next;
    }
    /** Initialize your data structure here. */
    public AllOne() {
        vhead.next = vtail;
        vtail.prev = vhead;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            VNode parent = node.parent;
            parent.removeNode(node);
            VNode newParent = getGreaterVNode(parent);
            newParent.addNode(node);
            if (parent.size == 0) removeVNode(parent);
        } else {
            Node node = new Node();
            node.key = key;
            VNode parent = getGreaterVNode(vtail);
            parent.addNode(node);
            map.put(key, node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) return;
        Node node = map.get(key);
        VNode parent = node.parent;
        parent.removeNode(node);
        if (parent.val == 1) {
            map.remove(key);
        } else {
            VNode vnode = getSmallerVNode(parent);
            vnode.addNode(node);
        }
        if (parent.size == 0) removeVNode(parent);
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (vhead.next == vtail) return "";
        return vhead.next.getHeadKey();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (vtail.prev == vhead) return "";
        return vtail.prev.getHeadKey();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */

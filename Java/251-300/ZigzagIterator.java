public class ZigzagIterator {

    Deque<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<>();
        Iterator<Integer> iter = v1.iterator();
        if (iter.hasNext()) queue.offer(iter);
        iter = v2.iterator();
        if (iter.hasNext()) queue.offer(iter);
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int val = iter.next();
        if (iter.hasNext()) queue.offer(iter);
        return val;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    });

    /** initialize your data structure here. */
    public MedianFinder() {
    }

    public void addNum(int num) {
        if (minHeap.size() > 0 && num >= minHeap.peek()) {
            minHeap.offer(num);
            if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            if (maxHeap.size() - 1 > minHeap.size())
                minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() == maxHeap.size() ?
            (minHeap.peek() + maxHeap.peek()) / 2.0 : maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

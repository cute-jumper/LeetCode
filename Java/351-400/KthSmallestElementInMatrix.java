public class KthSmallestElementInMatrix {
    static class Item implements Comparable<Item> {
        int val;
        int column;
        public Item(int val, int column) {
            this.val = val;
            this.column = column;
        }
        @Override
        public int compareTo(Item that) {
            return this.val - that.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int[] indices = new int[matrix[0].length];
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = 0; i < indices.length; i++) {
            pq.add(new Item(matrix[indices[i]][i], i));
        }
        for (int i = 0; i < k - 1; i++) {
            Item item = pq.poll();
            indices[item.column]++;
            if (indices[item.column] < matrix.length) {
                pq.add(new Item(matrix[indices[item.column]][item.column], item.column));
            }
        }
        return pq.poll().val;
    }
}

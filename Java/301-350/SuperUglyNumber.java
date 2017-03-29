public class SuperUglyNumber {

    static class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(primes.length, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.val < p2.val) return -1;
                    if (p1.val == p2.val) return 0;
                    return 1;
                }
            });
        int[] res = new int[n];
        int[] indices = new int[primes.length];
        res[0] = 1;
        for (int i = 0; i < primes.length; i++) {
            heap.add(new Pair(primes[i], i));
        }
        for (int i = 1; i < n; i++) {
            Pair minPair = heap.poll();
            res[i] = minPair.val;
            indices[minPair.index]++;
            while (!heap.isEmpty() && heap.peek().val == minPair.val) {
                Pair p = heap.poll();
                indices[p.index]++;
                heap.add(new Pair(res[indices[p.index]] * primes[p.index], p.index));
            }
            heap.add(new Pair(res[indices[minPair.index]] * primes[minPair.index], minPair.index));
        }
        return res[n - 1];
    }
}

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pts = new int[primes.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
        for (int i = 0; i < primes.length; i++) pq.offer(new int[] { primes[i], i });
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        while (ugly.size() < n) {
            int[] p = pq.poll();
            if (p[0] != ugly.get(ugly.size() - 1)) ugly.add(p[0]);
            pts[p[1]]++;
            pq.offer(new int[] { primes[p[1]] * ugly.get(pts[p[1]]), p[1] });
        }
        return ugly.get(ugly.size() - 1);
    }
}

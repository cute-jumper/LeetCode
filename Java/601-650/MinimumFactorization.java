public class MinimumFactorization {
    public int smallestFactorization(int a) {
        if (a < 10) return a;
        List<Integer> fs = new ArrayList<>();
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                fs.add(i);
                a /= i;
            }
        }
        if (a != 1 || fs.isEmpty()) return 0;
        long n = 0;
        for (int i = fs.size() - 1; i >= 0; i--) {
            n *= 10;
            n += fs.get(i);
        }
        return n > Integer.MAX_VALUE ? 0 : (int) n;
    }
}

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
        Collections.sort(fs);
        long n = 0;
        for (int i : fs) {
            n *= 10;
            n += i;
        }
        return n > Integer.MAX_VALUE ? 0 : (int) n;
    }
}

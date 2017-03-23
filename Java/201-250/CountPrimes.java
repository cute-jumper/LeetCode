public class CountPrimes {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        n--;
        boolean[] sieve = new boolean[n];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (!sieve[i]) {
                count++;
                int index = 2 * i + 1;
                while (index < n) {
                    sieve[index] = true;
                    index += i + 1;
                }
            }
        }
        return count;
    }
}

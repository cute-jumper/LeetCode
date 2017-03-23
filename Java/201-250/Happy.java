public class Happy {
    public boolean isHappy(int n) {
        Set<Integer> shown = new HashSet<>();
        while (shown.add(n) && n != 1) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                sum += digit * digit;
            }
            n = sum;
        }
        return n == 1;
    }
}

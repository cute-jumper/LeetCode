public class PermutaionSequence {
    public String getPermutation(int n, int k) {
        k--;
        int factor = 1;
        int product = 1;
        while (factor < n) {
            product *= factor;
            factor++;
        }
        factor--;
        boolean[] flags = new boolean[n];
        StringBuilder sb = new StringBuilder();
        while (factor >= 0) {
            int counter = 0;
            int target = k / product + 1;
            for (int i = 0; i < flags.length; i++) {
                if (!flags[i]) {
                    counter++;
                }
                if (counter == target) {
                    flags[i] = true;
                    sb.append(i + 1);
                    break;
                }
            }
            if (factor == 0) break;
            k %= product;
            product /= factor;
            factor--;
        }
        return sb.toString();
    }
}

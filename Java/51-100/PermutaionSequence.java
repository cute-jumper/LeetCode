public class PermutaionSequence {
    public String getPermutation(int n, int k) {
        int factor = 1;
        int product = 1;
        while (factor < n) {
            product *= factor;
            factor++;
        }
        k--;
        factor--;
        StringBuilder sb = new StringBuilder();
        List<Integer> cands = new ArrayList<>();
        for (int i = 1; i <= n; i++) cands.add(i);
        while (!cands.isEmpty()) {
            int index = k / product;
            sb.append(cands.get(index));
            cands.remove(index);
            k %= product;
            if (factor > 0) {
                product /= factor;
                factor--;
            }
        }
        return sb.toString();
    }
}

public class FourSum2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumAB = new HashMap<>();
        int res = 0;
        for (int i : A) {
            for (int j : B) {
                int sum = -(i + j);
                if (sumAB.containsKey(sum)) {
                    sumAB.put(sum, sumAB.get(sum) + 1);
                } else {
                    sumAB.put(sum, 1);
                }
            }
        }
        for (int i : C) {
            for (int j : D) {
                if (sumAB.containsKey(i + j)) res += sumAB.get(i + j);
            }
        }
        return res;
    }
}

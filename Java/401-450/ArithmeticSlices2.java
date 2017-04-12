public class ArithmeticSlices2 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        List<Map<Integer, Integer>> maps = new ArrayList<>(A.length);
        maps.add(new HashMap<Integer, Integer>());
        for (int i = 1; i < A.length; i++) {
            Map<Integer, Integer> currentMap = new HashMap<>();
            maps.add(currentMap);
            for (int j = 0; j < i; j++) {
                long lDiff = (long)A[i] - A[j];
                if (lDiff <= Integer.MIN_VALUE || lDiff > Integer.MAX_VALUE) continue;
                int diff = (int) lDiff;
                Map<Integer, Integer> prevMap = maps.get(j);
                int prev = prevMap.containsKey(diff) ? prevMap.get(diff) : 0;
                int curr = currentMap.containsKey(diff) ? currentMap.get(diff) : 0;
                currentMap.put(diff, curr + prev + 1);
                res += prev;
            }
        }
        return res;
    }
}

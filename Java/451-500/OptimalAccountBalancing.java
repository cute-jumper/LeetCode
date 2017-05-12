public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            update(map, trans[0], trans[2]);
            update(map, trans[1], -trans[2]);
        }
        List<Integer> balance = new ArrayList<>();
        for (Integer val : map.values()) {
            if (val != 0) balance.add(val);
        }
        Collections.sort(balance, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Math.abs(a) - Math.abs(b);
            }
        });
        return dfs(balance, 0);
    }
    private int dfs(List<Integer> balance, int step) {
        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < balance.size(); i++) {
            if (balance.get(i) != 0) {
                int iVal = balance.get(i);
                for (int j = i + 1, prev = 0; j < balance.size(); j++) {
                    int jVal = balance.get(j);
                    if (jVal == 0 || jVal == prev) continue;
                    if (jVal > 0 && iVal < 0 || jVal < 0 && iVal > 0) {
                        if (Math.abs(iVal) < Math.abs(jVal)) {
                            balance.set(j, iVal + jVal);
                            balance.set(i, 0);
                        } else {
                            balance.set(i, iVal + jVal);
                            balance.set(j, 0);
                        }
                        minStep = Math.min(minStep, dfs(balance, step + 1));
                        balance.set(i, iVal);
                        balance.set(j, jVal);
                        prev = jVal;
                    }
                }
                break;
            }
        }
        return minStep == Integer.MAX_VALUE ? step : minStep;
    }
    private void update(Map<Integer, Integer> map, int key, int val) {
        if (!map.containsKey(key)) map.put(key, 0);
        map.put(key, map.get(key) + val);
    }
}

public class EvaluateDivision {
    String[][] equations;
    double[] values;
    double val;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        this.equations = equations;
        this.values = values;
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            add(map, equations[i][0], i + 1);
            add(map, equations[i][1], - i - 1);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            if (dfs(map, new boolean[equations.length], query[0], query[1], 1)) {
                res[i] = this.val;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
    boolean dfs(Map<String, List<Integer>> map, boolean[] visited, String from, String to, double curr) {
        if (from.equals(to)) {
            val = curr;
            return map.containsKey(from);
        }
        if (!map.containsKey(from)) return false;
        List<Integer> connected = map.get(from);
        for (Integer i : connected) {
            int index = Math.abs(i) - 1;
            if (!visited[index]) {
                visited[index] = true;
                boolean success = dfs(map, visited, i < 0 ? equations[index][0] : equations[index][1], to,
                                    curr * (i < 0 ? 1 / values[index] : values[index]));
                visited[index] = false;
                if (success) return true;
            }
        }
        return false;
    }
    void add(Map<String, List<Integer>> map, String k, int val) {
        if (!map.containsKey(k)) map.put(k, new ArrayList<>());
        map.get(k).add(val);
    }
}

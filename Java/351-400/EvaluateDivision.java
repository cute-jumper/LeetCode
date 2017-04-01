public class EvaluateDivision {
    static class Item {
        String variable;
        double val;
        public Item(String variable, double val) {
            this.variable = variable;
            this.val = val;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Item>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new ArrayList<Item>());
            }
            map.get(equations[i][0]).add(new Item(equations[i][1], values[i]));
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new ArrayList<Item>());
            }
            map.get(equations[i][1]).add(new Item(equations[i][0], 1 / values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Set<String> visited = new HashSet<>();
            Set<String> prefix = new HashSet<>();
            Deque<Double> stack = new ArrayDeque<>();
            if (dfs(map, visited, prefix, stack, queries[i][0], queries[i][1])) {
                res[i] = 1;
                while (!stack.isEmpty()) {
                    res[i] *= stack.pop();
                }
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }
    public boolean dfs(Map<String, List<Item>> map, Set<String> visited, Set<String> prefix, Deque<Double> stack,
                      String start, String end) {
        if (start.equals(end)) {
            return map.containsKey(start);
        }
        if (!map.containsKey(start)) return false;
        List<Item> items = map.get(start);
        for (Item item : items) {
            if (visited.contains(item.variable) || prefix.contains(item.variable))
                continue;
            prefix.add(item.variable);
            stack.push(item.val);
            if (dfs(map, visited, prefix, stack, item.variable, end)) return true;
            prefix.remove(item.variable);
            stack.pop();
        }
        visited.add(start);
        return false;
    }
}

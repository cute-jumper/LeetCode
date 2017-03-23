public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            if (graph.containsKey(c1)) {
                graph.get(c1).add(c2);
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(c2);
                graph.put(c1, neighbors);
            }
        }
        Set<Integer> prefix = new HashSet<>();
        boolean[] visited = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && !dfs(i, graph, prefix, visited, res))
                return new int[0];
        }
        int[] resArr = new int[numCourses];
        int index = 0;
        for (Integer i : res) {
            resArr[index] = i;
            index++;
        }
        return resArr;
    }
    public boolean dfs(int n, Map<Integer, List<Integer>> graph, Set<Integer> prefix,
                    boolean[] visited, List<Integer> res) {
        if (prefix.contains(n)) return false;
        List<Integer> neighbors = graph.get(n);
        if (neighbors != null) {
            for (Integer i : neighbors) {
                if (!visited[i]) {
                    prefix.add(n);
                    boolean success = dfs(i, graph, prefix, visited, res);
                    prefix.remove(n);
                    if (!success) return false;
                }
            }
        }
        res.add(n);
        visited[n] = true;
        return true;
    }
}

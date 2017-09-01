public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] pre : prerequisites) {
            if (!graph.containsKey(pre[0])) graph.put(pre[0], new ArrayList<>());
            graph.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && detectCycle(i, graph, new boolean[numCourses], visited)) return false;
        }
        return true;
    }
    boolean detectCycle(int n, Map<Integer, List<Integer>> graph, boolean[] instack, boolean[] visited) {
        if (instack[n]) return true;
        instack[n] = true;
        if (graph.containsKey(n)) {
            List<Integer> neighbors = graph.get(n);
            for (int i : neighbors) {
                if (!visited[i] && detectCycle(i, graph, instack, visited)) return true;
            }
        }
        instack[n] = false;
        visited[n] = true;
        return false;
    }
}

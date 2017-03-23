public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        Set<Integer> prefix = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int c1 = prerequisites[i][0];
            int c2 = prerequisites[i][1];
            if (graph.containsKey(c1)) {
                graph.get(c1).add(c2);
            } else {
                List<Integer> preq = new ArrayList<>();
                preq.add(c2);
                graph.put(c1, preq);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) continue;
            if (detectCycle(i, graph, prefix, visited)) return false;
        }
        return true;
    }
    public boolean detectCycle(int n, Map<Integer, List<Integer>> graph, Set<Integer> prefix, boolean[] visited) {
        if (prefix.contains(n)) return true;
        List<Integer> neighbors = graph.get(n);
        if (neighbors != null) {
            for (Integer i : neighbors) {
                if (visited[i]) continue;
                prefix.add(n);
                boolean hasCycle = detectCycle(i, graph, prefix, visited);
                prefix.remove(n);
                if (hasCycle) return true;
            }
        }
        visited[n] = true;
        return false;
    }
}

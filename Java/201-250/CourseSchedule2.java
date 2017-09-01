public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prereq : prerequisites) {
            indegree[prereq[0]]++;
            if (!map.containsKey(prereq[1])) map.put(prereq[1], new ArrayList<>());
            map.get(prereq[1]).add(prereq[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            if (map.containsKey(course)) {
                for (Integer i : map.get(course)) {
                    if (indegree[i]-- == 1) queue.offer(i);
                }
            }
        }
        return index == res.length ? res : new int[0];
    }
    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     Map<Integer, List<Integer>> map = new HashMap<>();
    //     for (int[] pre : prerequisites) {
    //         if (!map.containsKey(pre[0])) map.put(pre[0], new ArrayList<>());
    //         map.get(pre[0]).add(pre[1]);
    //     }
    //     boolean[] visited = new boolean[numCourses];
    //     List<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < numCourses; i++) {
    //         if (!visited[i] && !dfs(list, map, i, new boolean[numCourses], visited)) return new int[0];
    //     }
    //     int[] res = new int[numCourses];
    //     for (int i = 0; i < numCourses; i++) res[i] = list.get(i);
    //     return res;
    // }
    // boolean dfs(List<Integer> list, Map<Integer, List<Integer>> map, int n, boolean[] instack, boolean[] visited) {
    //     if (instack[n]) return false;
    //     instack[n] = true;
    //     if (map.containsKey(n)) {
    //         List<Integer> neighbors = map.get(n);
    //         for (int i : neighbors) {
    //             if (!visited[i] && !dfs(list, map, i, instack, visited)) return false;
    //         }
    //     }
    //     instack[n] = false;
    //     visited[n] = true;
    //     list.add(n);
    //     return true;
    // }
}

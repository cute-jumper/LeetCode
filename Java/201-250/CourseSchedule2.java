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
}

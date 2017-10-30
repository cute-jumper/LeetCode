/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int val = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            val += e.importance;
            for (Integer sub : e.subordinates) queue.offer(sub);
        }
        return val;
    }
}

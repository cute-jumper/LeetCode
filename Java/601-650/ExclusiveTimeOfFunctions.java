public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int s = 0, id = -1;
        for (String log : logs) {
            String[] ps = log.split(":");
            int e = Integer.parseInt(ps[2]);
            if (ps[1].equals("start")) {
                stack.push(id);
                if (id != -1) {
                    res[id] += e - s;
                }
                id = Integer.parseInt(ps[0]);
            } else {
                e++;
                res[id] += e - s;
                id = stack.pop();
            }
            s = e;
        }
        return res;
    }
}

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[n];
        int time = 0;
        for (String log : logs) {
            String[] ps = log.split(":");
            int ts = Integer.parseInt(ps[2]);
            if (ps[1].equals("start")) {
                if (!stack.isEmpty()) res[stack.peek()] += ts - time;
                stack.push(Integer.parseInt(ps[0]));
            } else {
                ts++;
                res[stack.pop()] += ts - time;
            }
            time = ts;
        }
        return res;
    }
}

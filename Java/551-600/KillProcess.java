public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int id = ppid.get(i);
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            map.get(id).add(pid.get(i));
        }
        List<Integer> res =  new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            kill = queue.poll();
            res.add(kill);
            if (map.containsKey(kill)) {
                for (int i : map.get(kill)) queue.offer(i);
            }
        }
        return res;
    }
}

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        List<String> res = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String airport = stack.peek();
            while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
                airport = map.get(airport).poll();
                stack.push(airport);
            }
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }
}

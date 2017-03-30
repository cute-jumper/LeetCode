public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (map.containsKey(ticket[0])) {
                map.get(ticket[0]).add(ticket[1]);
            } else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(ticket[1]);
                map.put(ticket[0], pq);
            }
        }
        String departure = "JFK";
        Deque<String> stack = new ArrayDeque<>();
        stack.addFirst(departure);
        while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
            departure = map.get(departure).poll();
            stack.offerFirst(departure);
        }
        List<String> res = new ArrayList<>();
        while (res.size() <= tickets.length) {
            departure = stack.peekFirst();
            while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
                departure = map.get(departure).poll();
                stack.offerFirst(departure);
            }
            res.add(stack.pollFirst());
        }
        Collections.reverse(res);
        return res;
    }
}

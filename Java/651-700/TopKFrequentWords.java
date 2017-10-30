class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) return b.getKey().compareTo(a.getKey());
            return a.getValue() - b.getValue();
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) res.add(pq.poll().getKey());
        Collections.reverse(res);
        return res;
    }
}

public class LexicographicalNumber {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 1;
        while (current <= n) {
            stack.offerFirst(current);
            res.add(current);
            current *= 10;
        }
        while (!stack.isEmpty()) {
            current = stack.pollFirst();
            if (current % 10 < 9) {
                current++;
                while (current <= n) {
                    stack.offerFirst(current);
                    res.add(current);
                    current *= 10;
                }
            }
        }
        return res;
    }
}

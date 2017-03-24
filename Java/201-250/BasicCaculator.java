public class BasicCaculator {
    public int calculate(String s) {
        Deque<Integer> numQueue = new ArrayDeque<>();
        Deque<Character> opQueue = new ArrayDeque<>();
        int index = 0;
        boolean compute = false;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                index++;
                while (index <= s.length()) {
                    if (index < s.length()) c = s.charAt(index);
                    if (index == s.length() || c < '0' || c > '9') {
                        if (compute) {
                            int first = numQueue.removeLast();
                            char op = opQueue.removeLast();
                            if (op == '*') {
                                numQueue.addLast(first * num);
                            } else {
                                numQueue.addLast(first / num);
                            }
                            compute = false;
                        } else {
                            numQueue.addLast(num);
                        }
                        break;
                    }
                    c = s.charAt(index);
                    num *= 10;
                    num += c - '0';
                    index++;
                }
            }
            if (index < s.length() && c != ' ') {
                if (c == '*' || c == '/') {
                    compute = true;
                    opQueue.addLast(c);
                } else {
                    opQueue.addLast(c);
                }
            }
            index++;
        }
        while (!opQueue.isEmpty()) {
            char op = opQueue.removeFirst();
            int first = numQueue.removeFirst();
            int second = numQueue.removeFirst();
            if (op == '+') {
                numQueue.addFirst(first + second);
            } else {
                numQueue.addFirst(first - second);
            }
        }
        return numQueue.getFirst();
    }
}

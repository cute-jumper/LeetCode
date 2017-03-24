public class BasicCaculator {
    public int calculate(String s) {
        Deque<String> queue = new ArrayDeque<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                index++;
                while (index <= s.length()) {
                    if (index < s.length()) c = s.charAt(index);
                    if (index == s.length() || c < '0' || c > '9') {
                        String op = queue.peekLast();
                        if (op != null && (op.equals("*") || op.equals("/"))) {
                            queue.removeLast();
                            int first = Integer.parseInt(queue.removeLast());
                            int num =  Integer.parseInt(sb.toString());
                            if (op.equals("*")) queue.addLast(first * num + "");
                            else queue.addLast(first / num + "");
                        } else {
                            queue.addLast(sb.toString());
                        }
                        break;
                    }
                    sb.append(c);
                    index++;
                }
            }
            if (index < s.length() && c != ' ') {
                queue.addLast(c + "");
            }
            index++;
        }
        int res = Integer.parseInt(queue.removeFirst());
        while (!queue.isEmpty()) {
            char op = queue.removeFirst().charAt(0);
            int second = Integer.parseInt(queue.removeFirst());
            if (op == '+') {
                res += second;
            } else {
                res -= second;
            }
        }
        return res;
    }
}

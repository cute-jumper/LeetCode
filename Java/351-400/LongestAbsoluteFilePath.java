public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] ps = input.split("\n");
        Deque<Integer> stack = new ArrayDeque<>();
        int len = 0, max = 0;
        for (int i = 0; i < ps.length; i++) {
            int level = ps[i].lastIndexOf('\t');
            while (level + 2 <= stack.size()) len -= stack.pop();
            stack.push(ps[i].length() - level);
            len += stack.peek();
            if (ps[i].indexOf('.') != -1) max = Math.max(max, len - 1);
        }
        return max;
    }
}

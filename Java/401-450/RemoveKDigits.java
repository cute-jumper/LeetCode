public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }
        while (stack.size() > k) sb.append(stack.pollLast());
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

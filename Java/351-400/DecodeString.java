public class DecodeString {
    public String decodeString(String s) {
        int index = 0;
        int num = 0;
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
            } else if (c == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int repeat = numStack.pop();
                String repeatStr = sb.toString();
                sb = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    sb.append(repeatStr);
                }
            } else {
                sb.append(c);
            }
            index++;
        }
        return sb.toString();
    }
}

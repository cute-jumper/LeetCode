public class TagValidator {
    public boolean isValid(String code) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        while (i < code.length()) {
            if (i > 0 && stack.isEmpty()) return false;
            if (code.startsWith("</", i)) {
                int end = code.indexOf('>', i);
                int len = end - i - 2;
                if (end == -1 || len == 0 || len > 9 || stack.isEmpty()) return false;
                for (int j = i + 2; j < end; j++) {
                    char c = code.charAt(j);
                    if (c < 'A' || c > 'Z') return false;
                }
                if (!stack.pop().equals(code.substring(i + 2, end))) return false;
                i = end + 1;
            } else if (code.startsWith("<![CDATA[", i)) {
                int end = code.indexOf("]]>", i);
                if (end == -1) return false;
                i = end + 3;
            } else if (code.charAt(i) == '<') {
                int end = code.indexOf('>', i);
                int len = end - i - 1;
                if (end == -1 || len == 0 || len > 9) return false;
                for (int j = i + 1; j < end; j++) {
                    char c = code.charAt(j);
                    if (c < 'A' || c > 'Z') return false;
                }
                stack.push(code.substring(i + 1, end));
                i = end + 1;
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}

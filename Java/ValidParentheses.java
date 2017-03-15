public class ValidParentheses {
    public boolean isValid(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenParenthesis(c) || isCloseParenthesis(c)) {
                if (isOpenParenthesis(c)) {
                    stack.add(c);
                } else {
                    if (stack.size() != 0) {
                        char open = stack.remove(stack.size() - 1);
                        if (!isMatched(open, c)) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }
    public boolean isOpenParenthesis(char c) {
        return c == '{' || c == '(' || c == '[';
    }
    public boolean isCloseParenthesis(char c) {
        return c == '}' || c == ')' || c == ']';
    }
    public boolean isMatched(char open, char close) {
        return (open == '{' && close == '}') ||
            (open == '(' && close == ')') ||
            (open == '[' && close == ']');
    }
}

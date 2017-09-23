class ValidParenthesisString {
    public boolean checkValidString(String s) {
        return isValid(s, '(', ')') && isValid(new StringBuilder(s).reverse().toString(), ')', '(');
    }
    boolean isValid(String s, char le, char ri) {
        int cnt = 0, bal = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') cnt++;
            else if (c == le) bal++;
            else if (c == ri) bal--;
            if (bal + cnt < 0) return false;
        }
        return true;
    }
}

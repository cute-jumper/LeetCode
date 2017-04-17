public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(res, s, 0, 0, new char[] { '(', ')' });
        return res;
    }
    public void remove(List<String> res, String s, int start, int last_remove, char[] pair) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pair[0]) count++;
            else if (c == pair[1]) count--;
            if (count < 0) {
                for (int j = last_remove; j <= i; j++) {
                    if (s.charAt(j) != pair[1]) continue;
                    if (j == last_remove || s.charAt(j - 1) != pair[1]) {
                        remove(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                    }
                }
                return;
            }
        }
        if (count > 0) {
            remove(res, new StringBuilder(s).reverse().toString(), 0, 0, new char[] { ')', '(' });
        } else if (pair[0] == '(') {
            res.add(s);
        } else {
            res.add(new StringBuilder(s).reverse().toString());
        }
    }
}

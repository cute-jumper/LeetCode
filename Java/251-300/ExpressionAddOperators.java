public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, num, 0, target);
        return res;
    }
    public void dfs(List<String> res, String curr, long val, long prev, String num, int start, int target) {
        if (start == num.length()) {
            if (val == (long)target) res.add(curr);
            return;
        }
        long n = 0;
        for (int i = start; i < num.length(); i++) {
            int c = num.charAt(i) - '0';
            n *= 10;
            n += c;
            if (start == 0) {
                dfs(res, "" + n, n, n, num, i + 1, target);
            } else {
                dfs(res, curr + "+" + n, val + n, n, num, i + 1, target);
                dfs(res, curr + "-" + n, val - n, -n, num, i + 1, target);
                dfs(res, curr + "*" + n, val - prev + prev * n, prev * n, num, i + 1, target);
            }
            if (i == start && c == 0) break;
        }
    }
}

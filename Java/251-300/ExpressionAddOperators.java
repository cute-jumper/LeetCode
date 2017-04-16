public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, 1, num, 0, target);
        return res;
    }
    public void dfs(List<String> res, List<String> prefix, long curr, long multi, String num, int start, int target) {
        if (start >= num.length()) return;
        long val = 0;
        for (int i = start; i < num.length() - 1; i++) {
            val *= 10;
            val += num.charAt(i) - '0';
            if (val > Integer.MAX_VALUE) return;
            prefix.add(val + "");
            prefix.add("*");
            if (prefix.size() == 2 || !prefix.get(prefix.size() - 3).equals("-"))
                dfs(res, prefix, curr, multi * val, num, i + 1, target);
            else
                dfs(res, prefix, curr, -val, num, i + 1, target);
            prefix.remove(prefix.size() - 1);
            for (String op : new String[] { "+", "-" }) {
                prefix.add(op);
                if (prefix.size() == 2 || prefix.get(prefix.size() - 3).equals("*")) {
                    dfs(res, prefix, curr + multi * val, 1, num, i + 1, target);
                } else if (prefix.get(prefix.size() - 3).equals("+")) {
                    dfs(res, prefix, curr + val, 1, num, i + 1, target);
                } else {
                    dfs(res, prefix, curr - val, 1, num, i + 1, target);
                }
                prefix.remove(prefix.size() - 1);
            }
            prefix.remove(prefix.size() - 1);
            if (val == 0) return;
        }
        val *= 10;
        val += num.charAt(num.length() - 1) - '0';
        if (prefix.size() == 0) {
            if (val == target) res.add(num);
        } else {
            String op = prefix.get(prefix.size() - 1);
            if (op.equals("+") && curr + val == target ||
                op.equals("-") && curr - val == target ||
                op.equals("*") && curr + multi * val == target) {
                StringBuilder sb = new StringBuilder();
                for (String s : prefix) sb.append(s);
                sb.append(val);
                res.add(sb.toString());
            }
        }
    }
}

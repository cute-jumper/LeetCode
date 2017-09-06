public class StrobogrammaticNumber2 {
    int[] same = new int[] {0, 1, 8};
    int[] map = new int[] { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n);
        return res;
    }
    private String getReverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) sb.append(map[s.charAt(i) - '0']);
        return sb.toString();
    }
    public void dfs(List<String> res, String curr, int n) {
        if (n <= 1) {
            String reversed = getReverse(curr);
            if (n == 1) {
                for (int i : same) res.add(curr + i + reversed);
            } else {
                res.add(curr + reversed);
            }
            return;
        }
        for (int i : map) {
            if (i != -1 && (!curr.isEmpty() || i > 0)) dfs(res, curr + i, n - 2);
        }
    }
}

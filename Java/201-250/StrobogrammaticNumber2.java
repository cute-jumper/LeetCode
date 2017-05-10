public class StrobogrammaticNumber2 {
    int[] same = new int[] {0, 1, 8};
    int[] map = new int[10];
    public List<String> findStrobogrammatic(int n) {
        Arrays.fill(map, -1);
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[8] = 8;
        map[9] = 6;
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n);
        return res;
    }
    private String getReverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(map[s.charAt(i) - '0']);
        }
        return sb.toString();
    }
    public void dfs(List<String> res, StringBuilder curr, int n) {
        if (curr.length() == n / 2) {
            String s = curr.toString();
            String reversed = getReverse(s);
            if (n % 2 == 1) {
                for (int i : same) res.add(s + i + reversed);
            } else {
                res.add(s + reversed);
            }
            return;
        }
        for (int i : map) {
            if (i != -1) {
                if (curr.length() == 0 && i == 0) continue;
                curr.append(i);
                dfs(res, curr, n);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}

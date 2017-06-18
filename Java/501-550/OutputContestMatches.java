public class OutputContestMatches {
    public String findContestMatch(int n) {
        String[] map = new String[n];
        for (int i = 0; i < n; i++) {
            map[i] = "" + (i + 1);
        }
        while (n > 1) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                map[i] = "(" + map[i] + "," + map[j] + ")";
            }
            n /= 2;
        }
        return map[0];
    }
}

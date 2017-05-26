public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length - 1; i++) {
            if (cs[i] == '+' && cs[i + 1] == '+') {
                cs[i] = cs[i + 1] = '-';
                res.add(new String(cs));
                cs[i] = cs[i + 1] = '+';
            }
        }
        return res;
    }
}

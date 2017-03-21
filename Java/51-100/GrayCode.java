public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> sub = grayCode(n - 1);
        res.addAll(sub);
        for (int i = sub.size() - 1; i >= 0; i--) {
            res.add(sub.get(i) | (1 << (n - 1)));
        }
        return res;
    }
}

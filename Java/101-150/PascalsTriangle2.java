public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        if (rowIndex == 0) return res;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = res.size() - 1; j > 0; j--) {
                int prev = res.get(j - 1);
                res.set(j, prev + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}

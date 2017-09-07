public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", n, 0);
        return res;
    }
    private void generate(List<String> res, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curr);
            return;
        }
        if (right > 0) generate(res, curr + ')', left, right - 1);
        if (left > 0) generate(res, curr + '(', left - 1, right + 1);
    }
}

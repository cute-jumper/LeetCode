public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> init = new ArrayList<>();
        init.add("");
        return generate(n, 0, init);
    }
    public List<String> generate(int n, int counter, List<String> heads) {
        if (n == 0 && counter == 0) {
            return heads;
        }
        List<String> res = new ArrayList<>();
        List<String> newHeads = new ArrayList<>();
        if (n > 0) {
            for (String s : heads) {
                newHeads.add(s + '(');
            }
            res.addAll(generate(n - 1, counter + 1, newHeads));
        }
        if (counter > 0) {
            newHeads = new ArrayList<>();
            for (String s : heads) {
                newHeads.add(s + ')');
            }
            res.addAll(generate(n, counter - 1, newHeads));
        }
        return res;
    }
}

public class DifferentWaysToAddParens {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int index = 0; index < input.length(); index++) {
            char c = input.charAt(index);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> r1 = diffWaysToCompute(input.substring(0, index));
                List<Integer> r2 = diffWaysToCompute(input.substring(index + 1));
                for (Integer i : r1) {
                    for (Integer j : r2) {
                        if (c == '+') res.add(i + j);
                        else if (c == '-') res.add(i - j);
                        else res.add(i * j);
                    }
                }
            }
        }
        if (res.size() == 0 && input.length() > 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}

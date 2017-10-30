import java.util.*;

public class ExpressionAdd {
    public static void main(String[] args) {
        ExpressionAdd add = new ExpressionAdd();
        System.out.println(add.add("43868643", -68));

    }
    List<String> add(String s, int target) {
        List<String> res = new ArrayList<>();
        add(res, "", 0, s, 0, target);
        return res;
    }
    void add(List<String> res, String curr, int val, String s, int start, int target) {
        if (start == s.length()) {
            if (val == target) res.add(curr);
            return;
        }
        int n = 0;
        for (int i = start; i < s.length(); i++) {
            n = n * 10 + (s.charAt(i) - '0');
            if (start == 0) {
                add(res, "" + n, n, s, i + 1, target);
            } else {
                add(res, curr + "+" + n, val + n, s, i + 1, target);
                add(res, curr + "-" + n, val - n, s, i + 1, target);
            }
        }
    }
}

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        RemoveInvalidParentheses remove = new RemoveInvalidParentheses();
        System.out.println(remove.removeInvalid("((())"));
        System.out.println(remove.removeInvalid("((())))"));
        System.out.println(remove.removeInvalid("((())(())"));
        System.out.println(remove.removeInvalid("(((())(((())"));
    }
    public String removeInvalid(String s) {
        return removeInvalid(s, '(', ')');
    }
    private String removeInvalid(String s, char left, char right) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == left) {
                list.add(sb.length());
                count++;
            }
            else if (c == right) count--;
            if (count < 0) {
                count = 0;
            } else {
                sb.append(c);
            }
        }
        if (count > 0) {
            for (int i = list.size() - 1; i >= list.size() - count; i--) {
                sb.deleteCharAt(list.get(i));
            }
        }
        return sb.toString();
        // if (count > 0) return removeInvalid(new StringBuilder(sb).reverse().toString(), right, left);
        // else if (left == ')') return sb.reverse().toString();
        // return sb.toString();
    }
}

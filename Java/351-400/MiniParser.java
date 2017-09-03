/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        int num = 0, sign = 1;
        Deque<NestedInteger> stack = new ArrayDeque<>();
        NestedInteger curr = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') sign = -1;
            else if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                if (i == s.length() - 1) return new NestedInteger(num * sign);
            } else if (c == '[') {
                if (curr != null) stack.push(curr);
                curr = new NestedInteger();
            } else if (c == ']' || c == ',') {
                if (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                    curr.add(new NestedInteger(num * sign));
                    num = 0;
                    sign = 1;
                }
                if (c == ']' && !stack.isEmpty()) {
                    stack.peek().add(curr);
                    curr = stack.pop();
                }
            }
        }
        return curr;
    }
    // (require 'parsec)
    // (defun p-ni ()
    //   (parsec-or (p-int) (p-list)))
    // (defun p-int ()
    //   (cons 'int (parsec-many1-s (parsec-digit))))
    // (defun p-list ()
    //  (cons 'list (parsec-and
    //          (parsec-ch ?\[)
    //          (parsec-return (parsec-sepby (p-ni) (parsec-ch ?,))
    //            (parsec-ch ?\])))))
}

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
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int index = 0;
        NestedInteger current = null;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '[') {
                if (current != null) stack.offerFirst(current);
                current = new NestedInteger();
            } else if (c == '-' || c >= '0' && c <= '9') {
                int num = 0;
                boolean negative = (c == '-');
                if (negative) index++;
                while (index < s.length()) {
                    c = s.charAt(index);
                    if (c >= '0' && c <= '9') {
                        num *= 10;
                        num += c - '0';
                    }
                    if (index == s.length() - 1 || c == ']' || c == ',') {
                        num = negative ? -num : num;
                        if (current == null) current = new NestedInteger(num);
                        else current.add(new NestedInteger(num));
                        if (c == ']') index--;
                        break;
                    }
                    index++;
                }
            } else if (c == ']' && index < s.length() - 1) {
                stack.peekFirst().add(current);
                current = stack.pollFirst();
            }
            index++;
        }
        return current;
    }
}

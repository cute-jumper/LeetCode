/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += depthSum(ni.getList(), depth + 1);
            }
        }
        return sum;
    }
    // public int depthSum(List<NestedInteger> nestedList) {
    //     Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
    //     int depth = 1;
    //     int sum = 0;
    //     Iterator<NestedInteger> iter = nestedList.iterator();
    //     while (true) {
    //         while (!iter.hasNext() && !stack.isEmpty()) {
    //             iter = stack.pop();
    //             depth--;
    //         }
    //         if (!iter.hasNext()) break;
    //         NestedInteger ni = iter.next();
    //         if (ni.isInteger()) {
    //             sum += depth * ni.getInteger();
    //         } else {
    //             stack.push(iter);
    //             depth++;
    //             iter = ni.getList().iterator();
    //         }
    //     }
    //     return sum;
    // }
}

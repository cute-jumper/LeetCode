/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenList22 {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        Deque<NestedInteger> queue = new ArrayDeque<>();
        for (NestedInteger ni : nestedList) queue.offer(ni);
        while (!queue.isEmpty()) {
            NestedInteger ni = queue.poll();
            if (ni.isInteger()) res.add(ni.getInteger());
            else {
                List<NestedInteger> list = ni.getList();
                for (int i = list.size() - 1; i >= 0; i--) queue.offerFirst(list.get(i));
            }
        }
        return res;
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it iholds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Iterator<NestedInteger> iter;
    NestedInteger nextInteger;
    Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.iter = nestedList.iterator();
    }

    @Override
    public Integer next() {
        return this.nextInteger.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!iter.hasNext() && !stack.isEmpty()) {
            iter = stack.pollFirst();
        }
        if (iter.hasNext()) {
            NestedInteger ni = iter.next();
            while (!ni.isInteger()) {
                stack.offerFirst(iter);
                iter = ni.getList().iterator();
                if (!iter.hasNext()) {
                    while (!iter.hasNext() && !stack.isEmpty()) {
                        iter = stack.pollFirst();
                    }
                    if (!iter.hasNext()) return false;
                }
                ni = iter.next();
            }
            nextInteger = ni;
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
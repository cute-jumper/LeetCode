/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        getSubTreeSum(root, count);
        List<Integer> mostFreq = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max)
                mostFreq.add(entry.getKey());
        }
        int[] res = new int[mostFreq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mostFreq.get(i);
        }
        return res;
    }
    public int getSubTreeSum(TreeNode root, Map<Integer, Integer> count) {
        if (root == null) return 0;
        int sum = root.val + getSubTreeSum(root.left, count) +
            getSubTreeSum(root.right, count);
        if (count.containsKey(sum)) {
            count.put(sum, count.get(sum) + 1);
        } else {
            count.put(sum, 1);
        }
        return sum;
    }
}

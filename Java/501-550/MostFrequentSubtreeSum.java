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
        int max = -1;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max) cnt++;
            else if (entry.getValue() > max) {
                max = entry.getValue();
                cnt = 1;
            }
        }
        int[] res = new int[cnt];
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max) res[--cnt] = entry.getKey();
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

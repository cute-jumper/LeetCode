/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindModeInBST {
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        seekMode(count, root);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }
        int[] res = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            res[i] = modes.get(i);
        }
        return res;
    }
    public void seekMode(Map<Integer, Integer> count, TreeNode root) {
        if (root == null) return;
        if (count.containsKey(root.val)) {
            count.put(root.val, count.get(root.val) + 1);
        } else {
            count.put(root.val, 1);
        }
        seekMode(count, root.left);
        seekMode(count, root.right);
    }
}

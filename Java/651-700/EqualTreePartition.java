/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = getSum(root, map);
        if (s % 2 != 0) return false;
        if (s == 0) return map.get(s) > 1;
        return map.containsKey(s / 2);
    }
    int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int s = root.val + getSum(root.left, map) + getSum(root.right, map);
        if (map.containsKey(s)) map.put(s, map.get(s) + 1);
        else map.put(s, 1);
        return s;
    }
}

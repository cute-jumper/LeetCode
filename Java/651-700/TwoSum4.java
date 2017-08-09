/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return traverse(map, root, k);
    }
    boolean traverse(Map<Integer, Integer> map, TreeNode root, int k) {
        if (root == null) return false;
        int remain = k - root.val;
        if (map.containsKey(remain)) {
            if (root.val != remain || map.get(remain) > 1) return true;
        }
        if (!map.containsKey(root.val)) map.put(root.val, 1);
        else map.put(root.val, map.get(root.val) + 1);
        return traverse(map, root.left, k) || traverse(map, root.right, k);
    }
}

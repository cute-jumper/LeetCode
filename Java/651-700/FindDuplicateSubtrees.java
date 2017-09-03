/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        run(root, new HashMap<>(), res);
        return res;
    }
    String run(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "null";
        String s = root.val + "," + run(root.left, map, res) + "," + run(root.right, map, res);
        if (map.containsKey(s)) {
            if (map.get(s) == 1) res.add(root);
            map.put(s, map.get(s) + 1);
        } else map.put(s, 1);
        return s;
    }
}

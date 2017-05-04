/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }
    public int dfs(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int lh = dfs(res, root.left);
        int rh = dfs(res, root.right);
        int h = Math.max(lh, rh) + 1;
        if (h >= res.size()) res.add(new ArrayList<>());
        res.get(h).add(root.val);
        return h;
    }
}

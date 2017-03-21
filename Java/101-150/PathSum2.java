/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getPathSum(res, new ArrayList<Integer>(), root, sum, 0);
        return res;
    }
    public void getPathSum(List<List<Integer>> res,
                           List<Integer> path,
                           TreeNode root,
                           int sum,
                           int current) {
        if (root == null) {
            if (sum == current) res.add(path);
            return;
        }
        path.add(root.val);
        current += root.val;
        if (root.left == null) {
            getPathSum(res, new ArrayList<Integer>(path), root.right, sum, current);
        } else if (root.right == null) {
            getPathSum(res, new ArrayList<Integer>(path), root.left, sum, current);
        } else {
            getPathSum(res, new ArrayList<Integer>(path), root.left, sum, current);
            getPathSum(res, new ArrayList<Integer>(path), root.right, sum, current);
        }
    }
}

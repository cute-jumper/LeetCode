/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        boolean[] flags = new boolean[n];
        return getAllTrees(0, n - 1, flags);
    }
    public List<TreeNode> getAllTrees(int low, int high, boolean[] flags) {
        List<TreeNode> res = new ArrayList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            if (flags[i]) continue;
            flags[i] = true;
            List<TreeNode> lefts = getAllTrees(low, i - 1, flags);
            List<TreeNode> rights = getAllTrees(i + 1, high, flags);
            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode c = new TreeNode(i + 1);
                    c.left = l;
                    c.right = r;
                    res.add(c);
                }
            }
            flags[i] = false;
        }
        return res;
    }
}

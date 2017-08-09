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
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                line.add("");
            }
            res.add(line);
        }
        set(res, root, 0, width - 1, 0);
        return res;
    }
    int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    void set(List<List<String>> res, TreeNode root, int low, int high, int row) {
        if (root == null) return;
        int mid = (low + high) / 2;
        res.get(row).set(mid, root.val + "");
        set(res, root.left, low, mid - 1, row + 1);
        set(res, root.right, mid + 1, high, row + 1);
    }
}

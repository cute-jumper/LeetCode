/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Set<TreeNode> left = new LinkedHashSet<>();
        if (root.left == null) left.add(root);
        else getLeft(root, left);
        Set<TreeNode> leaves = new LinkedHashSet<>();
        getLeaves(root, leaves);
        Set<TreeNode> right = new LinkedHashSet<>();
        if (root.right == null) right.add(root);
        else getRight(root, right);
        for (TreeNode i : left) res.add(i.val);
        for (TreeNode i : leaves) {
            if (!left.contains(i)) res.add(i.val);
        }
        for (TreeNode i : right) {
            if (!left.contains(i) && !leaves.contains(i)) res.add(i.val);
        }
        return res;
    }
    void getLeft(TreeNode root, Set<TreeNode> set) {
        if (root == null) return;
        set.add(root);
        if (root.left == null) getLeft(root.right, set);
        else getLeft(root.left, set);
    }
    void getLeaves(TreeNode root, Set<TreeNode> set) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            set.add(root);
            return;
        }
        getLeaves(root.left, set);
        getLeaves(root.right, set);
    }
    void getRight(TreeNode root, Set<TreeNode> set) {
        if (root == null) return;
        if (root.right == null) getRight(root.left, set);
        else getRight(root.right, set);
        set.add(root);
    }
}

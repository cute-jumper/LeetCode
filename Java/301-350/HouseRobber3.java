/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class HouseRobber3 {
    static class Pair {
        int val1;
        int val2;
        public Pair(int val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
        public int maxVal() {
            return Math.max(val1, val2);
        }
    }
    public int rob(TreeNode root) {
        return maxTree(root).maxVal();
    }
    public Pair maxTree(TreeNode root) {
        if (root == null) return new Pair(0, 0);
        Pair left = maxTree(root.left);
        Pair right = maxTree(root.right);
        return new Pair(root.val + left.val2 + right.val2,
                        left.maxVal() + right.maxVal());
    }
}

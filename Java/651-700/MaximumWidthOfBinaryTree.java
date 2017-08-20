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
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> minNum = new ArrayList<>();
        run(root, minNum, 1, 0);
        return max;
    }
    void run(TreeNode root, List<Integer> minNum, int num, int depth) {
        if (root == null) return;
        if (depth >= minNum.size()) minNum.add(num);
        max = Math.max(max, num - minNum.get(depth) + 1);
        run(root.left, minNum, num << 1, depth + 1);
        run(root.right, minNum, (num << 1) + 1, depth + 1);
    }
}

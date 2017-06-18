/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTLongestConsecutiveSeq2 {
    int longest = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return longest;
    }
    int[] traverse(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int leftInc = 0, rightInc = 0, leftDec = 0, rightDec = 0;
        if (left[0] > 0 && root.val == root.left.val - 1) {
            leftInc = left[0];
        }
        if (left[1] > 0 && root.val == root.left.val + 1) {
            leftDec = left[1];
        }
        if (right[0] > 0 && root.val == root.right.val - 1) {
            rightInc = right[0];
        }
        if (right[1] > 0 && root.val == root.right.val + 1) {
            rightDec = right[1];
        }
        int path = Math.max(leftInc + rightDec, leftDec + rightInc) + 1;
        longest = Math.max(longest, path);
        return new int[] {Math.max(leftInc, rightInc) + 1, Math.max(leftDec, rightDec) + 1};
    }
}

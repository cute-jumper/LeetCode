/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FindLargestValueTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        if (root != null) current.add(root);
        while (!current.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : current) {
                max = Math.max(max, node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            res.add(max);
            current = next;
        }
        return res;
    }
}

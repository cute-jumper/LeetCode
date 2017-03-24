/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    public int depth(TreeNode node) {
        if (node == null) return -1;
        return 1 + depth(node.left);
    }
    public int countNodes(TreeNode root) {
        int count = 0;
        while (root != null) {
            int d = depth(root);
            int rd = depth(root.right);
            if (rd == d - 1) {
                count += (1 << d);
                root = root.right;
            } else {
                count += (1 << (d - 1));
                root = root.left;
            }
        }
        return count;
        /**
            This should past the test but not!!!!
            Using System.currentTimeMillis() to see this is very fast but
            leetcode gives different running results! Don't know why!
        */
        // if (root == null) return 0;
        // List<TreeNode> list = new ArrayList<>();
        // Set<TreeNode> visited = new HashSet<>();
        // int maxDepth = -1;
        // int count = 0;
        // TreeNode p = root;
        // while (p != null) {
        //     list.add(p);
        //     p = p.left;
        //     maxDepth++;
        // }
        // TreeNode[] stack = list.toArray(new TreeNode[list.size()]);
        // int index = stack.length - 1;
        // int depth = maxDepth;
        // while (index >= 0) {
        //     TreeNode node = stack[index];
        //     if (depth == maxDepth) {
        //         count++;
        //         depth--;
        //         visited.add(node);
        //         index--;
        //         continue;
        //     }
        //     node = node.right;
        //     if (node == null) {
        //         break;
        //     }
        //     if (visited.contains(node)) {
        //         visited.add(stack[index]);
        //         index--;
        //         depth--;
        //         continue;
        //     }
        //     while (node != null) {
        //         index++;
        //         stack[index] = node;
        //         node = node.left;
        //         depth++;
        //     }
        //     if (depth != maxDepth) break;
        // }
        // return count + (int)Math.pow(2, maxDepth) - 1;
    }
}

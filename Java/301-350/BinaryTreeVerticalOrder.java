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
    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;
    class Item {
        TreeNode node;
        int col;
        Item(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Item> queue = new ArrayDeque<>();
        if (root != null) queue.offer(new Item(root, 0));
        while (!queue.isEmpty()) {
            Item item = queue.poll();
            minCol = Math.min(minCol, item.col);
            maxCol = Math.max(maxCol, item.col);
            if (!map.containsKey(item.col)) map.put(item.col, new ArrayList<>());
            map.get(item.col).add(item.node.val);
            if (item.node.left != null) queue.offer(new Item(item.node.left, item.col - 1));
            if (item.node.right != null) queue.offer(new Item(item.node.right, item.col + 1));
        }
        for (int i = minCol; i <= maxCol; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

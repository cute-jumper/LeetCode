/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedList2BST {
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return buildBST(head, count);
    }
    public TreeNode buildBST(ListNode head, int count) {
        if (count == 0) return null;
        int mid = (count + 1) / 2;
        ListNode p = head;
        for (int i = 1; i < mid; i++) {
            p = p.next;
        }
        TreeNode root = new TreeNode(p.val);
        root.left = buildBST(head, mid - 1);
        root.right = buildBST(p.next, count - mid);
        return root;
    }
}

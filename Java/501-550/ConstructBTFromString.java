/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBTFromString {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;
        int index = s.indexOf('(');
        TreeNode root = new TreeNode(Integer.parseInt(index == -1 ? s : s.substring(0, index)));
        for (int i = index + 1, cnt = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else if (s.charAt(i) == ')') cnt--;
            if (cnt == 0) {
                root.left = str2tree(s.substring(index + 1, i));
                if (i + 1 < s.length()) root.right = str2tree(s.substring(i + 2, s.length() - 1));
                break;
            }
        }
        return root;
    }
}

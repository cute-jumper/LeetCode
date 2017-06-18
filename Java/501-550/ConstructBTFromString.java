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
        return str2tree(s.toCharArray(), 0, s.length() - 1);
    }
    TreeNode str2tree(char[] s, int start, int end) {
        if (start > end) return null;
        int i = s[start] == '-' ? start + 1 : start;
        int v = 0;
        while (i <= end && s[i] >= '0' && s[i] <= '9') {
            v *= 10;
            v += s[i] - '0';
            i++;
        }
        if (s[start] == '-') v = -v;
        TreeNode root = new TreeNode(v);
        if (i == end + 1) return root;
        int j = findEnd(s, i + 1, end);
        root.left = str2tree(s, i + 1, j - 1);
        if (j == end) return root;
        root.right = str2tree(s, j + 2, findEnd(s, j + 2, end) - 1);
        return root;
    }
    int findEnd(char[] s, int start, int end) {
        int pair = 1;
        for (int j = start + 1; j <= end; j++) {
            if (s[j] == '(') pair++;
            else if (s[j] == ')') pair--;
            if (pair == 0) return j;
        }
        return end;
    }
}

class Solution:
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
            n = TreeNode(v)
            n.left = root
            return n
        self.addOneRow1(root, v, d, 1)
        return root
    def addOneRow1(self, root, v, d, curr):
        if root == None:
            return
        if curr == d - 1:
            l, r = TreeNode(v), TreeNode(v)
            l.left, r.right = root.left, root.right
            root.left, root.right = l, r
            return
        self.addOneRow1(root.left, v, d, curr + 1)
        self.addOneRow1(root.right, v, d, curr + 1)

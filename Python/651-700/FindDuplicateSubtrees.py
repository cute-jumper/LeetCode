# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        from collections import defaultdict
        m = defaultdict(int)
        res = []
        def to_s(root):
            if root == None:
                return 'null'
            s = str(root.val)
            if root.left != None or root.right != None:
                s += ',' + to_s(root.left) + ',' + to_s(root.right)
            if m[s] == 1:
                res.append(root)
            m[s] += 1
            return s
        to_s(root)
        return res

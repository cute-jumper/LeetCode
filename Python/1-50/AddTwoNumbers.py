# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        vhead = ListNode(0)
        p = vhead
        carry = 0
        while l1 or l2 or carry > 0:
            v = carry
            if l1:
                v += l1.val
                l1 = l1.next
            if l2:
                v += l2.val
                l2 = l2.next
            carry = v / 10;
            p.next = ListNode(v % 10)
            p = p.next
        return vhead.next

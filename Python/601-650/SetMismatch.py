class Solution:
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        s = set([i for i in range(1, len(nums) + 1)])
        ret = []
        for i in nums:
            if i in s:
                s.remove(i)
            else:
                ret.append(i)
        ret.append(s.pop())
        return ret

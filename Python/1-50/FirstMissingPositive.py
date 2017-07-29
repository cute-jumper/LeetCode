class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for idx, num in enumerate(nums):
            if num <= 0 or num > len(nums):
                nums[idx] = len(nums) + 1
        for i in nums:
            i = abs(i) - 1
            if i < len(nums):
                nums[i] = -abs(nums[i])
        for idx, num in enumerate(nums):
            if num > 0:
                return idx + 1
        return len(nums) + 1

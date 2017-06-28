class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        d = {}
        start = maxLen = 0
        for i in range(len(s)):
            if s[i] in d:
                start = max(start, d[s[i]])
            maxLen = max(maxLen, i - start + 1)
            d[s[i]] = i + 1
        return maxLen

class Solution(object):
    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [ i for i in range(1, n + 1) ]
        dp[0] = 0
        for i in range(1, n // 2 + 1):
            for j in range(i * 2, n + 1, i):
                dp[j - 1] = min(dp[j - 1], dp[i - 1] + j / i)
        return dp[n - 1]

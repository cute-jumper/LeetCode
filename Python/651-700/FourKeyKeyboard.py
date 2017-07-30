class Solution(object):
    def maxA(self, N):
        """
        :type N: int
        :rtype: int
        """
        dp = [ i for i in range(1, N + 1)]
        for i in range(1, N):
            for j in range(i + 3, N + 1):
                dp[j - 1] = max(dp[j - 1], dp[i - 1] * (j - i - 1))
        return dp[N - 1]

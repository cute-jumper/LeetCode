class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        ret = []
        def dfs(start, curr, target):
            if target <= 0:
                if target == 0:
                    ret.append(curr)
                return
            for i in range(start, len(candidates)):
                dfs(i, curr + [candidates[i]], target - candidates[i])
        dfs(0, [], target)
        return ret

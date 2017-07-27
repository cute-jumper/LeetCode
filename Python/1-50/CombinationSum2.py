class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        ret = []
        def dfs(start, curr, target):
            if target <= 0 or start == len(candidates):
                if target == 0:
                    ret.append(curr)
                return
            for i in range(start, len(candidates)):
                if i == start or candidates[i] != candidates[i - 1]:
                    dfs(i + 1, curr + [candidates[i]], target - candidates[i])
        dfs(0, [], target)
        return ret

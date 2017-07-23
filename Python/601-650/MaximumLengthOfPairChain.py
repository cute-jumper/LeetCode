class Solution:
    def findLongestChain(self, pairs):
        """
        :type pairs: List[List[int]]
        :rtype: int
        """
        from operator import itemgetter
        pairs.sort(key=itemgetter(1, 0))
        c = None
        cnt = 0
        for p in pairs:
            if not c or c[1] < p[0]:
                c = p
                cnt += 1
        return cnt

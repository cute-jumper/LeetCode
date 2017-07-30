class Solution(object):
    def predictPartyVictory(self, senate):
        """
        :type senate: str
        :rtype: str
        """
        def helper(s, cnt, c):
            r = ''
            for i in s:
                if cnt == 0:
                    c = i
                if i == c:
                    cnt += 1
                    r += i
                else:
                    cnt -= 1
            if r.find('R') == -1:
                return 'Dire'
            if r.find('D') == -1:
                return 'Radiant'
            return helper(r, cnt, c)
        return helper(senate, 0, '')

class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = '1'
        for i in range(n - 1):
            s = self.getNext(s)
        return s
    def getNext(self, s):
        cnt = 1
        ch = s[0]
        ret = ''
        for i in range(1, len(s)):
            if s[i] != s[i - 1]:
                ret += str(cnt) + ch
                cnt = 1
                ch = s[i]
            else:
                cnt += 1
        return ret + str(cnt) + ch

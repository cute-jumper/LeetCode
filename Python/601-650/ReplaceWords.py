class Solution:
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        ps = sentence.split(' ')
        dict.sort()
        ret = []
        for w in ps:
            for d in dict:
                if w.startswith(d):
                    ret.append(d)
                    break
            else:
                ret.append(w)
        return ' '.join(ret)

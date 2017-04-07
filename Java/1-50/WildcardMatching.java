public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int aIndex = -1;
        int mIndex = -1;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                pIndex++;
                sIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                aIndex = pIndex;
                mIndex = sIndex;
                pIndex++;
            } else {
                if (aIndex == -1) return false;
                pIndex = aIndex + 1;
                sIndex = ++mIndex;
            }
        }
        while (pIndex < p.length()) {
            if (p.charAt(pIndex) != '*') return false;
            pIndex++;
        }
        return true;
    }
}

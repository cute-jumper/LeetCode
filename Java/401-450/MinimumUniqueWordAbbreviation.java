public class MinimumUniqueWordAbbreviation {
    int maxLen;
    int minLen;
    int minAbbr = -1;
    public String minAbbreviation(String target, String[] dictionary) {
        maxLen = minLen = target.length();
        List<Integer> bits = new ArrayList<>();
        for (String d : dictionary) {
            if (d.length() == target.length()) bits.add(getBits(target, d));
        }
        if (bits.size() == 0) return target.length() + "";
        bits.add(0);
        dfs(bits, 0, 0);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0, val = 1; i < maxLen; i++, val <<= 1) {
            if ((val & minAbbr) != 0) {
                if (cnt > 0) sb.append(cnt);
                sb.append(target.charAt(i));
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if (cnt != 0) sb.append(cnt);
        return sb.toString();
    }
    private int getLen(int abbr) {
        int len = maxLen;
        for (int i = 3, shift = 1; shift < maxLen; shift++, i <<= 1) {
            if ((i & abbr) == 0) len--;
        }
        return len;
    }
    private void dfs(List<Integer> bits, int curr, int start) {
        int abbrLen = getLen(curr);
        if (abbrLen >= minLen) return;
        boolean contained = false;
        for (Integer i : bits) {
            if (i == curr || (i & curr) == curr) {
                contained = true;
                break;
            }
        }
        if (!contained) {
            minLen = abbrLen;
            minAbbr = curr;
        } else {
            for (int i = start, val = 1 << start; i < maxLen; i++, val <<= 1) {
                if ((val & curr) == 0) {
                    dfs(bits, curr | val, i + 1);
                }
            }
        }
    }
    private int getBits(String s, String t) {
        int bit = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                bit |= (1 << i);
            }
        }
        return bit;
    }
}

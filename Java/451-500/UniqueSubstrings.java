public class UniqueSubstrings {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        int[] count = new int[26];
        int low = 0;
        count[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            char c = p.charAt(i);
            if (!(c - p.charAt(i - 1) == 1 || p.charAt(i - 1) - c == 25)) {
                low = i;
            }
            count[c - 'a'] = Math.max(count[c - 'a'], i - low + 1);
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }
}

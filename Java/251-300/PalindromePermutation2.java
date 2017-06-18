public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1 && odd++ == 1) return res;
        }
        solve(res, count, "", s.length());
        return res;
    }
    void solve(List<String> res, int[] count, String prefix, int k) {
        if (k == 0) {
            res.add(prefix + new StringBuilder(prefix).reverse().toString());
            return;
        }
        if (k == 1) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] == 1) {
                    char c = (char) i;
                    res.add(prefix + c + new StringBuilder(prefix).reverse().toString());
                    return;
                }
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                char c = (char) i;
                count[i] -= 2;
                solve(res, count, prefix + c, k - 2);
                count[i] += 2;
            }
        }
    }
}

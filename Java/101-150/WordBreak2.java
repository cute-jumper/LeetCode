public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> wd = new HashSet<>(wordDict);
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)] = 1;
        for (String w : wd) {
            for (int i = 0; i < w.length(); i++) count[w.charAt(i)]--;
        }
        for (int i = 0; i < count.length; i++)
            if (count[i] > 0) return res;
        dfs(new int[s.length()], res, new ArrayList<String>(), s, 0, wd);
        return res;
    }
    public boolean dfs(int[] memo, List<String> res, List<String> prefix, String s, int start, Set<String> wordDict) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String i : prefix) {
                sb.append(i);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return true;
        }
        if (memo[start] != 0) return false;
        StringBuilder sb = new StringBuilder();
        boolean success = false;
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                prefix.add(sb.toString());
                success = dfs(memo, res, prefix, s, i + 1, wordDict) || success;
                prefix.remove(prefix.size() - 1);
            }
        }
        if (!success) memo[start] = 1;
        return success;
    }
}

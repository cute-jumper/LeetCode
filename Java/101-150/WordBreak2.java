public class WordBreak2 {
    Set<Integer> failSet = new HashSet<>();
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
        dfs(res, new ArrayList<String>(), s, 0, wd);
        return res;
    }
    public void dfs(List<String> res, List<String> prefix, String s, int start, Set<String> wordDict) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String i : prefix) {
                sb.append(i);
                sb.append(' ');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        if (failSet.contains(start)) return;
        StringBuilder sb = new StringBuilder();
        boolean failed = true;
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (wordDict.contains(sb.toString())) {
                int oldSize = res.size();
                prefix.add(sb.toString());
                dfs(res, prefix, s, i + 1, wordDict);
                if (res.size() > oldSize) failed = false;
                prefix.remove(prefix.size() - 1);
            }
        }
        if (failed) failSet.add(start);
    }
}

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) set.add(word);
        for (String word : words) {
            dfs(res, set, word, 0);
        }
        return res;
    }
    public boolean dfs(List<String> res, Set<String> set, String word, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < word.length() - 1; i++) {
            sb.append(word.charAt(i));
            if (set.contains(sb.toString())) {
                if (dfs(res, set, word, i + 1)) return true;
            }
        }
        if (start != 0) {
            sb.append(word.charAt(word.length() - 1));
            if (set.contains(sb.toString())) {
                res.add(word);
                return true;
            }
        }
        return false;
    }
}

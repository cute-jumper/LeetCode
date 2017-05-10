public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, "", word, 0, false);
        return res;
    }
    private void dfs(List<String> res, String curr, String word, int start, boolean isDigit) {
        if (start == word.length()) {
            res.add(curr.toString());
            return;
        }
        dfs(res, curr + word.charAt(start), word, start + 1, false);
        if (isDigit) return;
        for (int i = start + 1; i <= word.length(); i++) {
            dfs(res, curr + (i - start), word, i, true);
        }
    }
}

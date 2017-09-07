public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(res, "", word, 0, 0);
        return res;
    }
    private void dfs(List<String> res, String curr, String word, int start, int count) {
        if (start == word.length()) {
            res.add(curr + (count > 0 ? count + "" : ""));
            return;
        }
        dfs(res, curr + (count > 0 ? count + "" : "") + word.charAt(start), word, start + 1, 0);
        dfs(res, curr, word, start + 1, count + 1);
    }
}

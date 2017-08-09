public class LetterCombinations {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(res, digits, 0, "");
        return res;
    }
    void dfs(List<String> res, String digits, int start, String curr) {
        if (start == digits.length()) {
            if (curr.length() > 0) res.add(curr);
            return;
        }
        String letters = map[digits.charAt(start) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            dfs(res, digits, start + 1, curr + letters.charAt(i));
        }
    }
    // public List<String> letterCombinations(String digits) {
    //     LinkedList<String> queue = new LinkedList<>();
    //     if (digits.length() == 0) return queue;
    //     queue.offer("");
    //     for (int i = 0; i < digits.length(); i++) {
    //         String cands = map[digits.charAt(i) - '0'];
    //         while (!queue.isEmpty() && queue.peek().length() == i) {
    //             String s = queue.poll();
    //             for (int j = 0; j < cands.length(); j++) {
    //                 queue.offer(s + cands.charAt(j));
    //             }
    //         }
    //     }
    //     return queue;
    // }

}

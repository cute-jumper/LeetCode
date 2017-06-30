public class LetterCombinations {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
    	List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        dfs(res, digits, "", 0);
        return res;
    }
    void dfs(List<String> res, String digits, String curr, int start) {
        if (start == digits.length()) {
            res.add(curr);
            return;
        }
        String cands = map[digits.charAt(start) - '0'];
        for (int i = 0; i < cands.length(); i++) {
            dfs(res, digits, curr + cands.charAt(i), start + 1);
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

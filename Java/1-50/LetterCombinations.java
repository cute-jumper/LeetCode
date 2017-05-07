public class LetterCombinations {
    public static String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int[] pos = new int[digits.length()];
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = pos.length - 1;
        while (index != -1) {
            sb.setLength(0);
            for (int i = 0; i < pos.length; i++) {
                String s = map[digits.charAt(i) - '0'];
                if (s.length() == 0) return res;
                sb.append(s.charAt(pos[i]));
            }
            res.add(sb.toString());
            for (index = pos.length - 1; index >=0; index--) {
                if (pos[index] == map[digits.charAt(index) - '0'].length() - 1) {
                    pos[index] = 0;
                } else {
                    pos[index]++;
                    break;
                }
            }
        }
        return res;
    }
}

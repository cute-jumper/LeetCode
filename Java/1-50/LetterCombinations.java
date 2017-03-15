public class LetterCombinations {
    public static String[] MAPPINGS = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> combs;
        if (digits.length() == 1) {
            combs = new ArrayList<String>() {{
                    add("");
                }};
        } else {
            combs = letterCombinations(digits.substring(1));
        }
        List<String> ret = new ArrayList<String>();
        char c = digits.charAt(0);
        if (Character.isDigit(c)) {
            for (int i =0; i < MAPPINGS[c - '0'].length(); i++) {
                char letter = MAPPINGS[c - '0'].charAt(i);
                for (String s : combs) {
                    ret.add(letter + s);
                }
            }
        }
        return ret;
    }
}

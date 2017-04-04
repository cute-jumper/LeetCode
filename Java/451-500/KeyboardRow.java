public class KeyboardRow {
    public String[] findWords(String[] words) {
        int[] letterRow = new int[26];
        char[][] keyboard = new char[][] {{'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'},
                                          {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'},
                                          {'Z', 'X', 'C', 'V', 'B', 'N', 'M'}};
        for (int row = 0; row < keyboard.length; row++) {
            for (char c : keyboard[row]) {
                letterRow[c - 'A'] = row;
            }
        }
        List<String> oneRow = new ArrayList<>();
        for (String s : words) {
            if (s.length() == 0) oneRow.add(s);
            else {
                boolean canType = true;
                int row = letterRow[toUpper(s.charAt(0)) - 'A'];
                for (int i = 1; i < s.length(); i++) {
                    if (letterRow[toUpper(s.charAt(i)) - 'A'] != row) {
                        canType = false;
                        break;
                    }
                }
                if (canType) oneRow.add(s);
            }
        }
        String[] res = new String[oneRow.size()];
        for (int i = 0; i < oneRow.size(); i++) {
            res[i] = oneRow.get(i);
        }
        return res;
    }
    public char toUpper(char c) {
        if (c <= 'z' && c >= 'a') return (char)('A' + c - 'a');
        return c;
    }
}

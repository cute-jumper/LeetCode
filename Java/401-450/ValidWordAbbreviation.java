public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (c >= 'a' && c <= 'z') {
                if (word.charAt(i) != c) return false;
                i++;
                j++;
            } else {
                int num = c - '0';
                if (num == 0) return false;
                j++;
                while (j < abbr.length()) {
                    c = abbr.charAt(j);
                    if (c >= '0' && c <= '9') {
                        num *= 10;
                        num += c - '0';
                        j++;
                    } else {
                        break;
                    }
                }
                i += num;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}

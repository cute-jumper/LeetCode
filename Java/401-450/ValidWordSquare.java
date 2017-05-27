public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words.get(0).length() != words.size()) return false;
        for (int i = 1; i < words.size(); i++) {
            String w = words.get(i);
            if (w.length() > words.size()) return false;
            for (int j = 0; j < i; j++) {
                if (j < w.length()) {
                    char c = w.charAt(j);
                    if (words.get(j).length() <= i || words.get(j).charAt(i) != c)
                        return false;
                } else if (words.get(j).length() > i) {
                    return false;
                }
            }
        }
        return true;
    }
}

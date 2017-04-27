public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) <= 'Z') count++;
        }
        return count == 0 || count == word.length() || count == 1 && word.charAt(0) <= 'Z';
    }
}

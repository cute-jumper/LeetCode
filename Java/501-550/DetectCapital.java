public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) return true;
        char c = word.charAt(0);
        int type = 0;
        if (c >= 'A' && c <= 'Z') type = 1;
        for (int i = 1; i < word.length(); i++) {
            c = word.charAt(i);
            if (type == 1) {
                if (c >= 'a' && c <= 'z') {
                    type = 2;
                } else {
                    type = 3;
                }
            } else if ((type == 0 || type == 2) && c >= 'A' && c <= 'Z') {
                return false;
            } else if (type == 3 && c >= 'a' && c <= 'z') {
                return false;
            }
        }
        return true;
    }
}

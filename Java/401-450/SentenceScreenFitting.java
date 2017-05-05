public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String s : sentence) {
            sb.append(s);
            sb.append(' ');
        }
        String s = sb.toString();
        int index = 0, len = s.length();
        for (int i = 0; i < rows; i++) {
            index += cols;
            while (index >= 0 && s.charAt(index % len) != ' ') index--;
            if (index >= 0 && s.charAt(index % len) == ' ') index++;
        }
        return index / len;
    }
}

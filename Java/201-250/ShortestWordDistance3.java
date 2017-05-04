public class ShortestWordDistance3 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1, min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2) && pos1 != -1) min = Math.min(min, i - pos1);
                pos1 = i;
            } else if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) min = Math.min(min, Math.abs(pos1 - pos2));
        }
        return min;
    }
}

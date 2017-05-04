public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int min = words.length;
        int update = 0;
        for (int i = 0; i < words.length; i++) {
            update &= 3;
            if (words[i].equals(word1)) {
                pos1 = i;
                update |= 5;
            } else if (words[i].equals(word2)) {
                pos2 = i;
                update |= 10;
            }
            if ((update & 3) == 3 && update > 3) min = Math.min(min, Math.abs(pos1 - pos2));
        }
        return min;
    }
}

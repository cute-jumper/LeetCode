public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1), index2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < index1.size() && j < index2.size();) {
            min = Math.min(min, Math.abs(index1.get(i) - index2.get(j)));
            if (index1.get(i) < index2.get(j)) i++;
            else j++;
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

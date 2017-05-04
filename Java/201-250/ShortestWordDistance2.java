public class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < idx1.size() && j < idx2.size()) {
            if (idx1.get(i) < idx2.get(j)) {
                min = Math.min(min, idx2.get(j) - idx1.get(i));
                i++;
            } else {
                min = Math.min(min, idx1.get(i) - idx2.get(j));
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<String, Integer> wordMap = new HashMap<>();
        int[] letterMap = new int[26];
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String word = words[i];
            if (letterMap[p - 'a'] == 0 && !wordMap.containsKey(word)) {
                letterMap[p - 'a'] = i + 1;
                wordMap.put(word, i + 1);
            } else if (!wordMap.containsKey(word) || letterMap[p - 'a'] != wordMap.get(word)) {
                return false;
            }
        }
        return true;
    }
}

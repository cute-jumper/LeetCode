public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        String[] l2sMap = new String[26];
        Map<String, Character> s2lMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (l2sMap[c - 'a'] == null && !s2lMap.containsKey(words[i])) {
                l2sMap[c - 'a'] = words[i];
                s2lMap.put(words[i], c);
                continue;
            }
            String word = l2sMap[c - 'a'];
            if (word != null && word.equals(words[i]) &&
                s2lMap.containsKey(words[i]) && s2lMap.get(words[i]) == c)
                continue;
            return false;
        }
        return true;
    }
}

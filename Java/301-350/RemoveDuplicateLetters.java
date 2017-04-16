public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int distinct = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a']++ == 0)
                distinct++;
        }
        char[] res = new char[distinct];
        boolean[] selected = new boolean[26];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (selected[c - 'a']) continue;
            while (index > 0 && c < res[index-1] && count[res[index-1] - 'a'] > 0) {
                index--;
                selected[res[index] - 'a'] = false;
            }
            if (index < distinct) {
                res[index++] = c;
                selected[c - 'a'] = true;
            }
        }
        return new String(res);
    }
}

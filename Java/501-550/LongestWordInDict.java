public class LongestWordInDict {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    if (a.length() > b.length()) return -1;
                    if (a.length() < b.length()) return 1;
                    return a.compareTo(b);
                }
            });
        for (String word : d) {
            if (isSubSeq(word, s))
                return word;
        }
        return "";
    }
    public boolean isSubSeq(String a, String b) {
        if (a.length() > b.length()) return false;
        int index = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            while (index < b.length() && b.charAt(index) != c) index++;
            if (index == b.length()) return false;
            index++;
        }
        return true;
    }
}

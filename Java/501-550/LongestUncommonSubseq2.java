public class LongestUncommonSubseq2 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    if (a.length() > b.length()) return -1;
                    if (a.length() < b.length()) return 1;
                    return 0;
                }
            });
        for (int i = 0; i < strs.length; i++) {
            boolean found = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubSeq(strs[i], strs[j])) {
                    found = false;
                    break;
                }
            }
            if (found) return strs[i].length();
        }
        return -1;
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

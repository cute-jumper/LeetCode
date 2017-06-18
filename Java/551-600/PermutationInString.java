public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] stat = new int[256];
        boolean[] shown = new boolean[256];
        int total = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            char c = s1.charAt(i);
            stat[c]++;
            if (!shown[c]) {
                total++;
                shown[c] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (shown[c]) {
                int v = --stat[c];
                if (v == 0) total--;
                else if (v == -1) total++;
            }
            if (i >= len) {
                c = s2.charAt(i - len);
                if (shown[c]) {
                    int v = ++stat[c];
                    if (v == 0) total--;
                    else if (v == 1) total++;
                }
            }
            if (total == 0) return true;
        }
        return false;
    }
}

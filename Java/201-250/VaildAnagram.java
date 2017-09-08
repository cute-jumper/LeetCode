public class VaildAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[256];
        int z = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) z--;
            if (count[t.charAt(i)]-- == 1) z++;
        }
        return z == 0;
    }
}

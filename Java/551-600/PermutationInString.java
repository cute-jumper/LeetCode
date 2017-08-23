public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]++;
        int start = 0, remain = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            if (count[s2.charAt(i)]-- >= 1) remain--;
            if (remain == 0) return true;
            if (i - start + 1 == s1.length() && count[s2.charAt(start++)]++ >= 0) remain++;
        }
        return false;
    }
}

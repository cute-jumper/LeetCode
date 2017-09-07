public class FindPermutation {
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        for (int i = 0, start = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == 'I') {
                for (int j = i; j >= start; j--) res[j] = start + i - j + 1;
                start = i + 1;
            }
        }
        return res;
    }
}

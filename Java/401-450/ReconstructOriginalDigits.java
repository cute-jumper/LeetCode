public class ReconstructOriginalDigits {
    public String originalDigits(String s) {
        int[][] base = new int[10][26];
        String[] digits = new String[] { "zero", "one", "two", "three", "four", "five",
                                         "six", "seven", "eight", "nine" };
        int[] l2n1 = new int[26];
        l2n1['z' - 'a'] = 1;
        l2n1['w' - 'a'] = 3;
        l2n1['u' - 'a'] = 5;
        l2n1['x' - 'a'] = 7;
        l2n1['g' - 'a'] = 9;
        int[] l2n2 = new int[26];
        l2n2['o' - 'a'] = 2;
        l2n2['h' - 'a'] = 4;
        l2n2['f' - 'a'] = 6;
        l2n2['s' - 'a'] = 8;
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i].length(); j++) {
                base[i][digits[i].charAt(j) - 'a']++;
            }
        }
        int[] count = new int[10];
        int[] all = new int[26];
        for (int i = 0; i < s.length(); i++) {
            all[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < l2n1.length; i++) {
            if (l2n1[i] != 0 && all[i] != 0) {
                count[l2n1[i] - 1] = all[i];
                for (int j = 0 ; j < 26; j++) {
                    all[j] -= count[l2n1[i] - 1] * base[l2n1[i] - 1][j];
                }
            }
        }
        for (int i = 0; i < l2n2.length; i++) {
            if (l2n2[i] != 0 && all[i] != 0) {
                count[l2n2[i] - 1] = all[i];
                for (int j = 0; j < 26; j++) {
                    all[j] -= count[l2n2[i] - 1] * base[l2n2[i] - 1][j];
                }
            }
        }
        count[9] = all['i' - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}

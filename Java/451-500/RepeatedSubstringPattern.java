public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] count = new int[256];
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i : count) {
            if (i != 0) min = gcd(i, min);
        }
        if (min == 1 || s.length() % min != 0) return false;
        for (int k = min; k > 1; k--) {
            if (s.length() % k != 0 || gcd(k, min) == 1) continue;
            boolean found = true;
            int len = s.length() / k;
            out:
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < k; j++) {
                    if (s.charAt(i) != s.charAt(i + j * len)) {
                        found = false;
                        break out;
                    }
                }
            }
            if (found) return true;
        }
        return false;
    }
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}

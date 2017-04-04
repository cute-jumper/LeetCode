public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        boolean[] nonPrimes = new boolean[s.length() + 1];
        for (int i = 2; i < nonPrimes.length; i++) {
            if (nonPrimes[i]) continue;
            int index = i + i;
            while (index < nonPrimes.length) {
                nonPrimes[index] = true;
                index += i;
            }
        }
        int len = 0;
        for (int i = 2; i < nonPrimes.length; i++) {
            if (nonPrimes[i] || s.length() % i != 0) continue;
            boolean found = true;
            out:
            for (int j = s.length() / i; j < s.length(); j += s.length() / i) {
                for (int k = 0; k < s.length() / i; k++) {
                    if (s.charAt(k) != s.charAt(j + k)) {
                        found = false;
                        break out;
                    }
                }
            }
            if (found) return true;
        }
        return false;
    }
}

public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        int appear = 0;
        int[] lenCount = new int[s.length() + 1];
        char prev = '\0';
        int low = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                if (i - low >= 3) lenCount[i - low]++;
                low = i;
            }
            if (c >= 'a' && c <= 'z') {
                if ((appear & 1) == 0) appear += 8;
                appear |= 1;
            } else if (c >= 'A' && c <= 'Z') {
                if ((appear & 2) == 0) appear += 8;
                appear |= 2;
            } else if (c >= '0' && c <= '9') {
                if ((appear & 4) == 0) appear += 8;
                appear |= 4;
            }
            prev = c;
        }
        if (s.length() - low >= 3) lenCount[s.length() - low]++;
        int miss = 3 - (appear >>> 3);
        if (s.length() < 6) {
            return Math.max(6 - s.length(), miss);
        }
        int op = 0;
        for (int i = 3; i < lenCount.length; i++) op += lenCount[i] * (i / 3);
        if (s.length() <= 20) {
            return Math.max(op, miss);
        }
        int del = s.length() - 20;
        out:
        while (del > 0) {
            int oldDel = del;
            for (int i = 3; i < 6; i++) {
                for (int j = i; j < lenCount.length; j += 3) {
                    if (lenCount[j] == 0) continue;
                    int reduced = Math.min(del / (i - 2), lenCount[j]);
                    del -= reduced * (i - 2);
                    lenCount[j - i + 2] += reduced;
                    lenCount[j] -= reduced;
                    if (del < i - 2) break out;
                }
            }
            if (oldDel == del) break;
        }
        op = 0;
        for (int i = 3; i < lenCount.length; i++) op += lenCount[i] * (i / 3);
        return s.length() - 20 + Math.max(op, miss);
    }
}

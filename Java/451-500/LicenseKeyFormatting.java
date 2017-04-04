public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        int len = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') len++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int index = 0;
        for (; count < len % K && index < S.length(); index++) {
            if (S.charAt(index) == '-') continue;
            sb.append(toUpper(S.charAt(index)));
            count++;
        }
        if (len % K != 0) sb.append('-');
        count = 0;
        for (int i = index; i < S.length(); i++) {
            if (S.charAt(i) == '-') continue;
            sb.append(toUpper(S.charAt(i)));
            count++;
            if (count % K == 0)
                sb.append('-');
        }
        if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    public char toUpper(char c) {
        if (c <= 'z' && c >= 'a') return (char)('A' + c - 'a');
        return c;
    }
}

public class Roman2Integer {
    public int romanToInt(String s) {
        if (s.length() == 0) return 0;
        char[] mappings = new char[26];
        mappings['I' - 'A'] = 1;
        mappings['V' - 'A'] = 5;
        mappings['X' - 'A'] = 10;
        mappings['L' - 'A'] = 50;
        mappings['C' - 'A'] = 100;
        mappings['D' - 'A'] = 500;
        mappings['M' - 'A'] = 1000;
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char after = s.charAt(i + 1);
            if (c == 'I' && (after == 'V' || after == 'X') ||
                c == 'X' && (after == 'L' || after == 'C') ||
                c == 'C' && (after == 'D' || after == 'M'))
                sum -= mappings[c - 'A'];
            else
                sum += mappings[c - 'A'];
        }
        return sum + mappings[s.charAt(s.length() - 1) - 'A'];
    }
}

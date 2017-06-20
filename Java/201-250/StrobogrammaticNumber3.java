public class StrobogrammaticNumber3 {
    char[] map = new char[256];
    char[] keys = new char[] { '0', '1', '6', '8', '9' };
    char[] sameKeys = new char[] { '0', '1', '8' };
    int count;
    public int strobogrammaticInRange(String low, String high) {
        map['0'] = '0';
        map['1'] = '1';
        map['6'] = '9';
        map['8'] = '8';
        map['9'] = '6';
        solve(low, high, "");
        return count;
    }
    void solve(String low, String high, String curr) {
        if (high.length() / 2 < curr.length()) return;
        if (curr.length() >= low.length() / 2 && high.length() / 2 >= curr.length()) {
            String rev = getReverse(curr);
            String s = curr + rev;
            if (compare(s, low) >= 0 && compare(s, high) <= 0) count++;
            if (curr.length() * 2 < high.length()) {
                for (char c : sameKeys) {
                    s = curr + c + rev;
                    if (compare(s, low) >= 0 && compare(s, high) <= 0) count++;
                }
            }
        }
        for (char c : keys) {
            if (curr.length() == 0 && c == '0') continue;
            solve(low, high, curr + c);
        }
    }
    int compare(String a, String b) {
        if (a.length() != b.length()) return a.length() - b.length();
        return a.compareTo(b);
    }
    String getReverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(map[s.charAt(i)]);
        }
        return sb.toString();
    }
}

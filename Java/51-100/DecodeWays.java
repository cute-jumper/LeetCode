public class DecodeWays {
    public int numDecodings(String s) {
        if (s.equals("")) return 0;
        int e = 1, e1 = 0, e2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int f = e1, f1 = 0, f2 = 0;
            if (c != '0') f += e;
            if (c <= '6') f += e2;
            if (c == '1') f1 = e;
            if (c == '2') f2 = e;
            e = f;
            e1 = f1;
            e2 = f2;
        }
        return e;
    }
}

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long val = Long.parseLong(n);
        List<String> cands = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) sb.append(9);
        if (sb.length() > 0) cands.add(sb.toString());
        sb.append(9);
        cands.add(sb.toString());
        sb.setLength(0);
        sb.append(1);
        for (int i = 0; i < len - 2; i++) sb.append(0);
        if (sb.length() < len) sb.append(1);
        cands.add(sb.toString());
        sb.setLength(1);
        for (int i = 0; i < len - 1; i++) sb.append(0);
        sb.append(1);
        cands.add(sb.toString());
        int half = (len + 1) / 2;
        if (half > 0) {
            boolean odd = len % 2 == 1;
            long v = Long.parseLong(n.substring(0, half));
            cands.add(getString(v + "", odd));
            if (odd || v != 1) cands.add(getString(v - 1 + "", odd));
            cands.add(getString(v + 1 + "", odd));
        }
        long res = Long.parseLong(cands.get(0));
        for (int i = 1; i < cands.size(); i++) {
            long v = Long.parseLong(cands.get(i));
            if (res == val) res = v;
            else if (v != val) {
                long d1 = Math.abs(v - val);
                long d2 = Math.abs(res - val);
                if (d1 < d2 || d1 == d2 && v < res) res = v;
            }
        }
        return res + "";
    }
    String getString(String half, boolean odd) {
        return half + new StringBuilder(half.substring(0, half.length() - (odd ? 1 : 0))).reverse().toString();
    }
}

class StringCompression {
    public int compress(char[] chars) {
        int start = 0, cnt = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[i - 1]) {
                chars[start++] = chars[i - 1];
                if (cnt > 1) {
                    String c = cnt + "";
                    for (int j = 0; j < c.length(); j++) chars[start++] = c.charAt(j);
                }
                cnt = 1;
            } else {
                cnt++;
            }
        }
        return start;
    }
}

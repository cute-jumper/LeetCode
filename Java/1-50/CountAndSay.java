public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) s = next(s);
        return s;
    }
    String next(String s) {
        int count = 0;
        char c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (count == 0 || s.charAt(i) != c) {
                if (count > 0) sb.append(count + "" + c);
                c = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString() + count + c;
    }
}

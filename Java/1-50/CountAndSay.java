public class CountAndSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        while (n > 1) {
            String s = sb.toString();
            sb = new StringBuilder();
            char prev = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == prev) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(prev);
                    prev = s.charAt(i);
                    count = 1;
                }
            }
            if (count != 0) {
                sb.append(count);
                sb.append(prev);
            }
            n--;
        }
        return sb.toString();
    }
}

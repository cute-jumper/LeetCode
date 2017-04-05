public class ReverseString2 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            for (int j = i; j < s.length() && j < i + k; j++) {
                sb.append(s.charAt(Math.min(i + k, s.length()) - (j - i + 1)));
            }
            for (int j = i + k; j < s.length() && j < i + 2 * k; j++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
}

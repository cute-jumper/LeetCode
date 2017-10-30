import java.util.*;

public class SortString {
    public static void main(String[] args) {
        System.out.println(sortString("abeshacd1cad32231a"));
        System.out.println(sortString("a"));
    }
    public static String sortString(String s) {
        if (s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        boolean isDigit = true;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || isDigit != (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                char[] cs = curr.toString().toCharArray();
                Arrays.sort(cs);
                sb.append(new String(cs));
                curr.setLength(0);
                isDigit = !isDigit;
            }
            if (i < s.length()) curr.append(s.charAt(i));
        }
        return sb.toString();
    }
}

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1, c = 0; i >= 0 || j >= 0 || c != 0; i--, j--) {
            if (i >= 0) c += a.charAt(i) - '0';
            if (j >= 0) c += b.charAt(j) - '0';
            sb.append(c & 1);
            c >>= 1;
        }
        return sb.reverse().toString();
    }
}

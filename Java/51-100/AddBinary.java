public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length(), lenB = b.length();
        int carry = 0;
        for (int i = 0; i < lenA || i < lenB; i++) {
            int c1 = 0, c2 = 0;
            if (i < lenA) {
                c1 = a.charAt(lenA - 1 - i) - '0';
            }
            if (i < lenB) {
                c2 = b.charAt(lenB - 1 - i) - '0';
            }
            int s = c1 + c2 + carry;
            sb.append(s & 1);
            carry = (s >> 1) & 1;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

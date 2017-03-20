public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int s = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            carry = s / 2;
            sb.append(s % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int s = a.charAt(i) - '0' + carry;
            carry = s / 2;
            sb.append(s % 2);
            i--;
        }
        while (j >= 0) {
            int s = b.charAt(j) - '0' + carry;
            carry = s / 2;
            sb.append(s % 2);
            j--;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}

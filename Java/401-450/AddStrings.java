public class AddStrings {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < num1.length() || i < num2.length(); i++) {
            int v = carry;
            if (i < num1.length())
                v += num1.charAt(num1.length() - 1 - i) - '0';
            if (i < num2.length())
                v += num2.charAt(num2.length() - 1 - i) - '0';
            sb.append(v % 10);
            carry = v / 10;
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}

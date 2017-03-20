public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int length = len1 + len2;
        for (int i = 0; i < length - 1; i++) {
            int product = carry;
            carry = 0;
            for (int j = 0; j <= i && j < len1; j++) {
                int k = i - j;
                if (k >= len2) continue;
                product += (num1.charAt(len1 - 1 - j) - '0') * (num2.charAt(len2 - 1 - k) - '0');
                int c = product / 10;
                carry += c;
                product %= 10;
            }
            sb.append(product);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

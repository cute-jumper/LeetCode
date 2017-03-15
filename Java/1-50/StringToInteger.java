public class StringToInteger {
    public int myAtoi(String str) {
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length())
            return 0;
        boolean negative = str.charAt(index) == '-';
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            index++;
        }
        int res = 0;
        final int MAX_VALUE = Integer.MAX_VALUE / 10;
        while (index < str.length()) {
            char c = str.charAt(index);
            if (c >= '0' && c <= '9') {
                if (res < 0 || res > MAX_VALUE) {
                    if (negative) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                res *= 10;
                res += c - '0';
                if (res < 0) {
                    if (!negative) {
                        return Integer.MAX_VALUE;
                    } else if (res > Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
            index++;
        }
        if (negative) {
            return -res;
        }
        return res;
    }
}

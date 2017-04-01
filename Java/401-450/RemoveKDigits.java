public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        int low = 0;
        StringBuilder sb = new StringBuilder();
        while (k != 0 && low + k < num.length()) {
            char min = '9' + 1;
            for (int i = low; i <= low + k; i++) {
                if (num.charAt(i) < min) {
                    min = num.charAt(i);
                }
            }
            for (int i = low; i <= low + k; i++) {
                if (num.charAt(i) == min) {
                    k -= i - low;
                    low = i + 1;
                    sb.append(min);
                    break;
                }
            }
        }
        if (k == 0) sb.append(num.substring(low));
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') index++;
        return index == sb.length() ? "0" : sb.substring(index).toString();
    }
}

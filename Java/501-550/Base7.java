public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) sb.append('-');
        return sb.reverse().toString();
    }
}

public class FractionToRecurDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> shown = new HashMap<>();
        boolean negative = numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0;
        long quot = (long)numerator / denominator;
        long rem = numerator % denominator;
        StringBuilder sb = new StringBuilder();
        sb.append(quot);
        if (rem != 0) {
            sb.append('.');
        }
        int index = sb.length();
        shown.put(rem, index);
        while (rem != 0) {
            rem *= 10;
            quot = Math.abs(rem / denominator);
            rem = rem % denominator;
            sb.append(quot);
            index++;
            if (shown.containsKey(rem)) {
                break;
            } else {
                shown.put(rem, index);
            }
        }
        if (rem != 0) {
            sb.append(')');
            index = shown.get(rem);
            sb.insert(index, '(');
        }
        if (negative && sb.charAt(0) != '-')
            return "-" + sb.toString();
        return sb.toString();
    }
}

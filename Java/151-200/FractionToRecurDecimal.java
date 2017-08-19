public class FractionToRecurDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long d = Math.abs((long) denominator);
        long q = (long) numerator / denominator;
        long r = Math.abs(numerator % d);
        if (r == 0) return "" + q;
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) != (denominator < 0)) sb.append('-');
        sb.append(Math.abs(q) + ".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(r, sb.length());
        while (r != 0) {
            r *= 10;
            sb.append(r / d);
            r %= d;
            if (map.containsKey(r)) {
                String s = sb.toString();
                return s.substring(0, map.get(r)) + "(" + s.substring(map.get(r)) + ")";
            } else {
                map.put(r, sb.length());
            }
        }
        return sb.toString();
    }
}

public class FractionAdditionSubtraction {
    class Frac {
        int num;
        int denom;
        public Frac(int num, int denom) {
            int g = gcd(num, denom);
            this.num = num / g;
            this.denom = denom / g;
        }
        public Frac add(Frac other) {
            int n = other.denom * num;
            int m = other.num * denom;
            return new Frac(m + n, other.denom * denom);
        }
        private int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);
            while (b != 0) {
                int tmp = a;
                a = b;
                b = tmp % b;
            }
            return a;
        }
    }
    public String fractionAddition(String expression) {
        boolean sign = true;
        Frac f = null;
        for (int i = 0, start = 0; i < expression.length(); i++) {
            while (i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                i++;
            }
            if (i != start) {
                if (f == null) {
                    f = parse(expression.substring(start, i));
                } else {
                    f = f.add(parse(expression.substring(start, i)));
                }
            }
            start = i;
        }
        return f.num + "/" + f.denom;
    }
    private Frac parse(String s) {
        String[] ps = s.split("/");
        return new Frac(Integer.parseInt(ps[0]), Integer.parseInt(ps[1]));
    }
}

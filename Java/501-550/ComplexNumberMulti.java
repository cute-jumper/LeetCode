public class ComplexNumberMulti {
    public String complexNumberMultiply(String a, String b) {
        String[] an = a.split("\\+");
        String[] bn = b.split("\\+");
        int a1 = Integer.parseInt(an[0]);
        int a2 = Integer.parseInt(an[1].substring(0, an[1].lastIndexOf('i')));
        int b1 = Integer.parseInt(bn[0]);
        int b2 = Integer.parseInt(bn[1].substring(0, bn[1].lastIndexOf('i')));
        return a1 * b1 - a2 * b2 + "+" + (a1 * b2 + a2 * b1) + "i";
    }
}

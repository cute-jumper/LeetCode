import java.math.BigInteger;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= (num.length() - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) break;
            for (int j = i + 1; num.length() - j >= Math.max(i, j - i); j++) {
                if (num.charAt(i) == '0' && j > i + 1) break;
                BigInteger first = new BigInteger(num.substring(0, i));
                BigInteger second = new BigInteger(num.substring(i, j));
                if (check(num.substring(j), first, second)) return true;
            }
        }
        return false;
    }
    public boolean check(String num, BigInteger first, BigInteger second) {
        if (num.length() == 0) return false;
        BigInteger sum = first.add(second);
        String sumStr = sum.toString();
        if (sumStr.equals(num)) return true;
        if (num.startsWith(sumStr)) {
            return check(num.substring(sumStr.length()), second, sum);
        }
        return false;
    }
}

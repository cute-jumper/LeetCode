public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int[] res = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            int s = digits[i] + carry;
            carry = s / 10;
            res[i] = s % 10;
        }
        if (carry == 0) {
            return res;
        } else {
            int[] newRes = new int[res.length + 1];
            newRes[0] = 1;
            for (int i = 0; i < res.length; i++) {
                newRes[i + 1] = res[i];
            }
            return newRes;
        }
    }
}

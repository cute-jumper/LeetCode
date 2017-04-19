public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        StringBuilder sb = new StringBuilder();
        int prev = 0, curr;
        while (n > 0) {
            curr = n % 10;
            if (curr < prev) {
                char[] ca = sb.toString().toCharArray();
                int index = 0;
                for (; index < ca.length; index++) {
                    if (ca[index] - '0' > curr) break;
                }
                int tmp = ca[index] - '0';
                ca[index] = (char)(curr + '0');
                long res = (n / 10 * 10 + tmp) * (long)Math.pow(10, ca.length) + Integer.parseInt(new String(ca));
                if (res > Integer.MAX_VALUE) return -1;
                return (int)res;
            }
            sb.append(curr);
            n /= 10;
            prev = curr;
        }
        return -1;
    }
}

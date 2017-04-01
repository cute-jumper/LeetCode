public class ConvertNumber2Hex {
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int val = (num >>> (28 - i * 4)) & 15;
            if (val == 0) {
                if (sb.length() > 0) sb.append(0);
            } else if (val < 10) {
                sb.append(val);
            } else {
                sb.append((char)('a' + val - 10));
            }
        }
        return sb.toString();
    }
}

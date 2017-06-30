public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int groupCount = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += groupCount) {
                sb.append(s.charAt(j));
                int next = j + groupCount - 2 * i;
               	if (i > 0 && i < numRows - 1 && next < len) sb.append(s.charAt(next));
            }
        }
        return sb.toString();
    }
}

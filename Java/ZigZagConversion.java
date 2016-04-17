public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int groupNum = 2 * numRows - 2;
        int index = 0;
        while (index < s.length()) {
            sb.append(s.charAt(index));
            index += groupNum;
        }
        for (int i = 1; i < numRows - 1; i++) {
            index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                int newIndex = index + groupNum - 2 * (index % groupNum);
                if (newIndex < s.length()) {
                    sb.append(s.charAt(newIndex));
                } else {
                    break;
                }
                index += groupNum;
            }
        }
        index = numRows - 1;
        while (index < s.length()) {
            sb.append(s.charAt(index));
            index += groupNum;
        }
        return sb.toString();
    }
}

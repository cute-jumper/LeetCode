public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int groupNum = 2 * numRows - 2;
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                if (!(i == 0 || i == numRows - 1)) {
                    int newIndex = index + groupNum - 2 * (index % groupNum);
                    if (newIndex < s.length()) {
                        sb.append(s.charAt(newIndex));
                    } else {
                        break;
                    }
                }
                index += groupNum;
            }
        }
        return sb.toString();
    }
}

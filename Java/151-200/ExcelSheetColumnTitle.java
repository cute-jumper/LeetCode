public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        } while (n > 0);
        return sb.reverse().toString();
    }
}

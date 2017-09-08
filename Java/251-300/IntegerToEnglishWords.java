public class IntegerToEnglishWords {
    final String[] small = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] large = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String s = "";
        for (int i = 0; num != 0; i++, num /= 1000) {
            if (num % 1000 != 0) s = convert(num % 1000) + large[i] + " " + s;
        }
        return s.trim();
    }
    String convert(int i) {
        if (i == 0) return "";
        if (i < 20) return small[i] + " ";
        if (i < 100) return tens[i / 10] + " " + convert(i % 10);
        return convert(i / 100) + "Hundred " + convert(i % 100);
    }
}

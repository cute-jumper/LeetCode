public class IntegerToEnglishWords {
    final String[] small = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] large = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {

        if (num == 0) return "Zero";
        String s = "";
        int largeIndex = 0;
        while (num > 0) {
            if (num % 1000 > 0)
                s = convert(num % 1000) + large[largeIndex] + " " + s;
            num /= 1000;
            largeIndex++;
        }
        return s.trim();
    }
    String convert(int n) {
        if (n == 0) return "";
        if (n < 20) return small[n] + " ";
        if (n < 100) return tens[n / 10] + " " + convert(n % 10);
        return small[n / 100] + " Hundred " + convert(n % 100);
    }
}

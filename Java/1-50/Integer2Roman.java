public class Integer2Roman {
    public String intToRoman(int num) {
        int[] steps = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < steps.length; i++) {
            while (num >= steps[i]) {
                sb.append(strs[i]);
                num -= steps[i];
            }
        }
        return sb.toString();
    }
}

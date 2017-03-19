public class Integer2Roman {
    public String intToRoman(int num) {
        int[] steps = new int[] { 1, 5, 10, 50, 100, 500, 1000 };
        int[] limits = new int[] { 1, 4, 9, 40, 90, 400, 900 };
        char[] letters = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        int index = steps.length - 1;
        while (num > 0) {
            while (num >= limits[index]) {
                int n = num / steps[index];
                int substract = 0;
                if (n == 0) {
                    sb.append(letters[(index + 1) / 2 * 2 - 2]);
                    sb.append(letters[index]);
                    substract = limits[index];
                } else {
                    for (int i = 0; i < n; i++) {
                        sb.append(letters[index]);
                    }
                    substract = n * steps[index];
                }
                num -= substract;
            }
            index--;
        }
        return sb.toString();
    }
}

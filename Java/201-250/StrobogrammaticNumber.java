public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[10];
        map[0] = 0;
        map[1] = 1;
        map[6] = 9;
        map[8] = 8;
        map[9] = 6;
        int low = 0, high = num.length() - 1;
        while (low <= high) {
            if (map[num.charAt(low) - '0'] != num.charAt(high) - '0') return false;
            low++;
            high--;
        }
        return true;
    }
}

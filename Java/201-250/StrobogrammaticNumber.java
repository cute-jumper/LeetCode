public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[] { 0, 1, -1, -1, -1, -1, 9, -1, 8, 6 };
        int low = 0, high = num.length() - 1;
        while (low <= high) {
            if (map[num.charAt(low++) - '0'] != num.charAt(high--) - '0') return false;
        }
        return true;
    }
}

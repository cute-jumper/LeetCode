public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 3) return num == 1;
        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) return true;
            if (i * i > num) return false;
        }
        return false;
    }
}

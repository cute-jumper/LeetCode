public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                if (countL++ == 2) return false;
            } else {
                countL = 0;
                if (c == 'A' && countA++ == 1) return false;
            }
        }
        return true;
    }
}

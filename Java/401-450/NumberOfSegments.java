public class NumberOfSegments {
    public int countSegments(String s) {
        int count = 0;
        boolean found = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ' && !found) {
                found = true;
            } else if (c == ' ' && found) {
                found = false;
                count++;
            }
        }
        if (found) count++;
        return count;
    }
}

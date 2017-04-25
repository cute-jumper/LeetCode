public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder(s.substring(1));
        sb.append(s.substring(0, s.length() - 1));
        return sb.toString().indexOf(s) != -1;
    }
}

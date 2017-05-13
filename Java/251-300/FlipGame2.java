public class FlipGame2 {
    Map<String, Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if (map.containsKey(s)) return map.get(s);
        boolean success = false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+' &&
                !canWin(s.substring(0, i) + "-" + s.substring(i + 2))) {
                success = true;
                break;
            }
        }
        map.put(s, success);
        return success;
    }
}

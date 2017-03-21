public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        getIPAddresses(res, s, 0, "", 4);
        return res;
    }
    public void getIPAddresses(List<String> res, String s, int start, String prefix, int k) {
        if (start == s.length()) return;
        if (k == 1) {
            if (s.length() - start > 3 || s.length() - start > 1 && s.charAt(start) == '0') return;
            int sub = Integer.parseInt(s.substring(start));
            if (sub < 256) res.add((prefix + "." + sub).substring(1));
        }
        for (int i = 0; i < 3 && start + i < s.length(); i++) {
            int sub = Integer.parseInt(s.substring(start, start + i + 1));
            if (sub < 256)
                getIPAddresses(res, s, start + i + 1, prefix + "." + sub, k - 1);
            if (s.charAt(start) == '0') break;
        }
    }
}

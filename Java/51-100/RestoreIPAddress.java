public class RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        getIPAddresses(res, s, 0, "", 4);
        return res;
    }
    public void getIPAddresses(List<String> res, String s, int start, String prefix, int k) {
        if (k == 0 && start == s.length()) {
            res.add(prefix);
            return;
        }
        if (s.length() - start > 3 * k) return;
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            int sub = Integer.parseInt(s.substring(start, start + i));
            if (sub < 256)
                getIPAddresses(res, s, start + i, prefix + sub + (k == 1 ? "" : "."), k - 1);
            if (sub == 0) return;
        }
    }
}

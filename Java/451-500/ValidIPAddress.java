public class ValidIPAddress {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) return "IPv4";
        if (isIPv6(IP)) return "IPv6";
        return "Neither";
    }
    public boolean isIPv4(String IP) {
        String[] parts = IP.split("\\.");
        if (parts.length != 4) return false;
        if (IP.charAt(IP.length() - 1) == '.') return false;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() == 0) return false;
            if (parts[i].charAt(0) == '0' && parts[i].length() > 1)
                return false;
            int num = 0;
            for (int j = 0; j < parts[i].length(); j++) {
                char c = parts[i].charAt(j);
                if (c <= '9' && c >= '0') {
                    num *= 10;
                    num += c - '0';
                    if (num > 255) return false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isIPv6(String IP) {
        String[] parts = IP.split(":");
        if (parts.length != 8) return false;
        if (IP.charAt(IP.length() - 1) == ':') return false;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() == 0 || parts[i].length() > 4) return false;
            for (int j = 0; j < parts[i].length(); j++) {
                char c = parts[i].charAt(j);
                if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' ||
                    c >= 'A' && c <= 'F'))
                    return false;
            }
        }
        return true;
    }
}

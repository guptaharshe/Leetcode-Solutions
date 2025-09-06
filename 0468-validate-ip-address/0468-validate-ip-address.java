class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.chars().filter(ch -> ch == '.').count() == 3) {
            return isIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.chars().filter(ch -> ch == ':').count() == 7) {
            return isIPv6(queryIP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }
    
    private boolean isIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String p : parts) {
            if (p.length() == 0 || p.length() > 3) return false;
            if (p.charAt(0) == '0' && p.length() != 1) return false;
            for (char c : p.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int val = Integer.parseInt(p);
            if (val < 0 || val > 255) return false;
        }
        return true;
    }
    
    private boolean isIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;
        String hexDigits = "0123456789abcdefABCDEF";
        for (String p : parts) {
            if (p.length() == 0 || p.length() > 4) return false;
            for (char c : p.toCharArray()) {
                if (hexDigits.indexOf(c) == -1) return false;
            }
        }
        return true;
    }
}

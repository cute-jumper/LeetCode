public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < version1.length() || index2 < version2.length()) {
            int v1 = 0;
            while (index1 < version1.length() && version1.charAt(index1) != '.') {
                v1 *= 10;
                v1 += version1.charAt(index1) - '0';
                index1++;
            }
            int v2 = 0;
            while (index2 < version2.length() && version2.charAt(index2) != '.') {
                v2 *= 10;
                v2 += version2.charAt(index2) - '0';
                index2++;
            }
            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
            index1++;
            index2++;
        }
        return 0;
    }
}

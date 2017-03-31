public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int maxLen = 0;
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        int len = 0;
        for (int i = 0; i < parts.length; i++) {
            int level = getLevel(parts[i]);
            while (prefix.size() > level) {
                prefix.remove(prefix.size() - 1);
            }
            len = prefix.get(prefix.size() - 1) + parts[i].length() - level + 2;
            prefix.add(len);
            if (isFile(parts[i]) && len - 1> maxLen) {
                maxLen = len - 1;
            }
        }
        return maxLen;
    }
    public boolean isFile(String name) {
        int index = name.indexOf('.');
        return index != -1 && index < name.length() - 1;
    }
    public int getLevel(String name) {
        int index = 0;
        while (name.charAt(index) == '\t') index++;
        return index + 1;
    }
}

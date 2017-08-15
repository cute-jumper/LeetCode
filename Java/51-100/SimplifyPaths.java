public class SimplifyPaths {
    public String simplifyPath(String path) {
        String[] ps = path.split("/");
        String[] dirs = new String[ps.length];
        int index = 0;
        for (String p : ps) {
            if (p.equals("..")) index = Math.max(index - 1, 0);
            else if (!(p.equals(".") || p.equals(""))) dirs[index++] = p;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append('/' + dirs[i]);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}

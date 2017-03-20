public class SimplifyPaths {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        ArrayList<String> current = new ArrayList<>();
        for (int i = 0; i < components.length; i++) {
            if (components[i].equals("..")) {
                if (current.size() != 0)
                    current.remove(current.size() - 1);
            } else if (!(components[i].equals(".") || components[i].equals(""))) {
                current.add(components[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (current.size() == 0) return "/";
        for (String s : current)
            sb.append("/" + s);
        return sb.toString();
    }
}

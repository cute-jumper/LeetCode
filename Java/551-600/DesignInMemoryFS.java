public class FileSystem {
    class File {
        String content;
        Map<String, File> files = new HashMap<>();
        public List<String> getFiles() {
            List<String> res = new ArrayList<>();
            for (String f : files.keySet()) res.add(f);
            Collections.sort(res);
            return res;
        }
        public File getFile(String name) {
            if (!files.containsKey(name)) return null;
            return files.get(name);
        }
    }
    File root;
    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        if (path.equals("/")) return root.getFiles();
        String[] ps = path.split("/");
        File f = root;
        for (String name : ps) {
            if (name.length() == 0) continue;
            f = f.getFile(name);
        }
        if (f.content != null) {
            List<String> res = new ArrayList<>();
            res.add(ps[ps.length - 1]);
            return res;
        }
        return f.getFiles();
    }
    public File mkdirHelper(String path) {
        String[] ps = path.split("/");
        File f = root;
        for (String name : ps) {
            if (name.length() == 0) continue;
            File c = f.getFile(name);
            if (c == null) {
                f.files.put(name, new File());
                f = f.getFile(name);
            } else {
                f = c;
            }
        }
        return f;
    }
    public void mkdir(String path) {
        mkdirHelper(path);
    }

    public void addContentToFile(String filePath, String content) {
        File f = mkdirHelper(filePath);
        if (f.content == null) f.content = content;
        else f.content = f.content + content;
    }

    public String readContentFromFile(String filePath) {
        File f = mkdirHelper(filePath);
        return f.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

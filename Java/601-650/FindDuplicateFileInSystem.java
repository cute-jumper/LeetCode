public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            for (int i = 1; i < parts.length; i++) {
                String[] names = parts[i].split("\\(");
                String content = names[1].substring(0, names[1].length() - 1);
                if (!map.containsKey(content)) map.put(content, new ArrayList<>());
                map.get(content).add(dir + "/" + names[0]);
            }
        }
        for (List<String> i : map.values()) {
            if (i.size() > 1) res.add(i);
        }
        return res;
    }
}

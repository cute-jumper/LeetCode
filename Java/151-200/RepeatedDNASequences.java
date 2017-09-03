public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> shown = new HashSet<>();
        Set<String> added = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!shown.add(sub) && added.add(sub)) res.add(sub);
        }
        return res;
    }
}

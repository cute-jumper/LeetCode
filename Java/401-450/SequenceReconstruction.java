public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org.length > 0 && seqs.size() == 0) return false;
        int[] idx = new int[org.length + 1];
        Arrays.fill(idx, -1);
        for (int i = 0; i < org.length; i++) {
            if (org[i] > org.length || org[i] < 1) return false;
            idx[org[i]] = i;
        }
        Map<Integer, Set<Integer>> shown = new HashMap<>();
        boolean flag = false;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                flag = true;
                int val = seq.get(i);
                if (val < 1 || val > org.length || idx[val] == -1)
                    return false;
                if (i > 0) {
                    int prev = seq.get(i - 1);
                    if (idx[prev] >= idx[val]) return false;
                    if (!shown.containsKey(prev)) shown.put(prev, new HashSet<>());
                    shown.get(prev).add(val);
                }
            }
        }
        if (!flag) return false;
        for (int i = 0; i < org.length - 1; i++) {
            if (!shown.containsKey(org[i]) || !shown.get(org[i]).contains(org[i+1])) return false;
        }
        return true;
    }
}

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return b[0] - a[0];
                    return a[1] - b[1];
                }
            });
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);
        int[][] res = new int[people.length][];
        for (int i = 0; i < res.length; i++) res[i] = list.poll();
        return res;
    }
}

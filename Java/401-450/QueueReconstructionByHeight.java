public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] > b[0]) return -1;
                    if (a[0] < b[0]) return 1;
                    if (a[1] < b[1]) return -1;
                    if (a[1] > b[1]) return 1;
                    return 0;
                }
            });
        int index = 0;
        while (index < people.length) {
            if (people[index][1] >= list.size()) {
                list.add(people[index]);
            } else {
                list.add(people[index][1], people[index]);
            }
            index++;
        }
        int[][] res = new int[index][];
        index = 0;
        for (int[] p : list) {
            res[index] = p;
            index++;
        }
        return res;
    }
}

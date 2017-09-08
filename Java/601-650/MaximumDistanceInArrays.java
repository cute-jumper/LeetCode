public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1), dist = 0;
        for (int i = 1; i < arrays.size(); i++) {
            int f = arrays.get(i).get(0), e = arrays.get(i).get(arrays.get(i).size() - 1);
            dist = Math.max(dist, e - min);
            dist = Math.max(dist, max - f);
            min = Math.min(f, min);
            max = Math.max(e, max);
        }
        return dist;
    }
}

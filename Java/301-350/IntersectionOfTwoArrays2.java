public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums1) {
            if (freq.containsKey(i)) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        List<Integer> intersect = new ArrayList<>();
        for (int i : nums2) {
            if (freq.containsKey(i) && freq.get(i) != 0) {
                intersect.add(i);
                freq.put(i, freq.get(i) - 1);
            }
        }
        int[] res = new int[intersect.size()];
        int index = 0;
        for (int i : intersect) {
            res[index] = i;
            index++;
        }
        return res;
    }
}

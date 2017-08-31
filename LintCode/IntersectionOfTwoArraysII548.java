public class IntersectionOfTwoArraysII548 {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        List<Integer> intersect = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                if (map.get(i) >= 0) intersect.add(i);
            }
        }
        int[] res = new int[intersect.size()];
        for (int i = 0; i < res.length; i++) res[i] = intersect.get(i);
        return res;
    }
}

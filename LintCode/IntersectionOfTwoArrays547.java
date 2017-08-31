public class IntersectionOfTwoArrays547 {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);
        Set<Integer> intersect = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) intersect.add(i);
        }
        int[] res = new int[intersect.size()];
        Iterator<Integer> it = intersect.iterator();
        for (int i = 0; i < res.length; i++) res[i] = it.next();
        return res;
    }
}

public class IntersectionOfTwoArraysII548 {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                i++;
                res.add(nums2[j++]);
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) r[i] = res.get(i);
        return r;
    }
}

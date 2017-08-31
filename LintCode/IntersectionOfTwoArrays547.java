public class IntersectionOfTwoArrays547 {
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
                res.add(nums1[i]);
                while (i < nums1.length - 1 && nums1[i] == nums1[i + 1]) i++;
                i++;
                while (j < nums2.length - 1 && nums2[j] == nums2[j + 1]) j++;
                j++;
            } else if (nums1[i] < nums2[j]) i++;
            else j++;
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) r[i] = res.get(i);
        return r;
    }
}

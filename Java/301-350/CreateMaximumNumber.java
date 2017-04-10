public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = null;
        for (int i = 0; i <= k && i <= nums1.length; i++) {
            if (k - i > nums2.length) continue;
            int[] k1 = getKthMax(nums1, i);
            int[] k2 = getKthMax(nums2, k - i);
            int[] candidate = new int[k];
            int index = 0, index1 = 0, index2 = 0;
            while (index < k) {
                if (isLarger(k1, k2, index1, index2)) {
                    candidate[index++] = k1[index1++];
                } else {
                    candidate[index++] = k2[index2++];
                }
            }
            if (res == null || isLarger(candidate, res, 0, 0)) res = candidate;
        }
        return res;
    }
    public boolean isLarger(int[] nums1, int[] nums2, int i, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    public int[] getKthMax(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums.length - i > k - index && index > 0 && nums[i] > res[index-1]) index--;
            if (index < k) res[index++] = nums[i];
        }
        return res;
    }
}

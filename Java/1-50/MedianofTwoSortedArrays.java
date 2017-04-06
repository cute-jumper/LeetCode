public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = nums1.length, half = (nums1.length + nums2.length + 1) / 2;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = half - mid1;
            if (mid1 < nums1.length && nums2[mid2 - 1] > nums1[mid1]) low = mid1 + 1;
            else if (mid1 > 0 && nums1[mid1 - 1] > nums2[mid2]) high = mid1 - 1;
            else {
                int first = 0;
                if (mid1 == 0) first = nums2[mid2 - 1];
                else if (mid2 == 0) first = nums1[mid1 - 1];
                else first = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                if ((nums1.length + nums2.length) % 2 == 1) return first;
                int second = 0;
                if (mid1 == nums1.length) second = nums2[mid2];
                else if (mid2 == nums2.length) second = nums1[mid1];
                else second = Math.min(nums1[mid1], nums2[mid2]);
                return (first + second) / 2.0;
            }
        }
        return 0;
    }
}

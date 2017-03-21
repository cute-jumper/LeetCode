public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n + m - 1; i >= n; i--) nums1[i] = nums1[i - n];
        int i = n;
        int j = 0;
        int index = 0;
        while (i < m + n && j < n) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums2[j];
                j++;
            } else {
                nums1[index] = nums1[i];
                i++;
            }
            index++;
        }
        while (i < m + n) {
            nums1[index] = nums1[i];
            i++;
            index++;
        }
        while (j < n) {
            nums1[index] = nums2[j];
            j++;
            index++;
        }
    }
}

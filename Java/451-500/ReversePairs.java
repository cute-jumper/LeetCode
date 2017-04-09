public class ReversePairs {
    public int mergeSort(int[] a, int[] m, int low, int high) {
        if (low >= high) return 0;
        int count = 0;
        int mid = low + (high - low) / 2;
        count += mergeSort(a, m, low, mid);
        count += mergeSort(a, m, mid + 1, high);
        count += merge(a, m, low, mid, high);
        return count;
    }
    public int merge(int[] a, int[] m, int low, int mid, int high) {
        int count = 0;
        int i = low;
        int j = mid + 1;
        int index = low;
        while (i <= mid && j <= high) {
            if ((long)a[i] > 2 * (long)a[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                m[index++] = a[i++];
            } else {
                m[index++] = a[j++];
            }
        }
        while (i <= mid) {
            m[index++] = a[i++];
        }
        while (j <= high) {
            m[index++] = a[j++];
        }
        for (i = low; i <= high; i++) a[i] = m[i];
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }
}

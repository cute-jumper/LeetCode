public class HIndex2 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= len - mid) high = mid - 1;
            else low = mid + 1;
        }
        return len - low;
    }
}

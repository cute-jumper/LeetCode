public class HIndex2 {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        int maxH = 0;
        while (low < high) {
            int mid = (low + high) / 2;
            int h = citations.length - mid;
            if (citations[mid] >= h) {
                maxH = h;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return maxH;
    }
}

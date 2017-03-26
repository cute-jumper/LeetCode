public class HIndex {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int i = 0 ; i < citations.length; i++) {
            count[Math.min(citations[i], citations.length)]++;
        }
        int total = 0;
        for (int i = citations.length; i >= 0; i--) {
            total += count[i];
            if (total >= i) return i;
        }
        return 0;
    }
}

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0, start = 0, end = 0;
        for (int i : timeSeries) {
            if (i >= end) {
                total += end - start;
                start = i;
            }
            end = i + duration;
        }
        return total + end - start;
    }
}

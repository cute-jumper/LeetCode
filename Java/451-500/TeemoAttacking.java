public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        int start = 0;
        int end = 0;
        for (int time : timeSeries) {
            if (time >= end) {
                total += end - start;
                start = time;
                end = start + duration;
            } else {
                end = time + duration;
            }
        }
        total += end - start;
        return total;
    }
}

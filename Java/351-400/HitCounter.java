public class HitCounter {

    int[] hits;
    int[] count;

    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[300];
        count = new int[300];
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        int old = hits[index];
        if (old == timestamp) {
            count[index]++;
        } else {
            hits[index] = timestamp;
            count[index] = 1;
        }
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < hits.length; i++) {
            if (hits[i] > timestamp - 300) total += count[i];
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

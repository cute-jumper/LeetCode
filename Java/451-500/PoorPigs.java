public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int x = minutesToTest / minutesToDie + 1;
        long total = 1;
        int pig = 0;
        while (total < (long) buckets) {
            total *= x;
            pig++;
        }
        return pig;
    }
}

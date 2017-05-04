/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cand, i)) cand = i;
        }
        for (int i = 0; i < n; i++) {
            if (i == cand) continue;
            if (!knows(i, cand) || knows(cand, i)) return -1;
        }
        return cand;
    }
}

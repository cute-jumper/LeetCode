public class EliminationGame {
    public int lastRemaining(int n) {
        int first = 1;
        int step = 1;
        int end = n;
        int dir = 1;
        while (first != end) {
            int last = first + (end - first) / (2 * step) * 2 * step;
            int tmp = first;
            if (last == first) {
                return end;
            }
            if (last == end) {
                first = end - dir * step;
                end = tmp + dir * step;
            } else {
                first = end;
                end = tmp + dir * step;
            }
            dir = -dir;
            step <<= 1;
        }
        return first;
    }
}

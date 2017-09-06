public class EliminationGame {
    public int lastRemaining(int n) {
        int remain = n, head = 1, step = 1;
        boolean l2r = true;
        while (remain > 1) {
            if (l2r || remain % 2 == 1) head += step;
            step += step;
            remain /= 2;
            l2r = !l2r;
        }
        return head;
    }
}

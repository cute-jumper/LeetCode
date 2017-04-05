public class BeautifulArrangement {
    public int countArrangement(int N) {
        return countArr(N, new int[N], 1);
    }
    public int countArr(int N, int[] arrange, int current) {
        if (current > N) return 1;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arrange[i] == 0 &&
                (current % (i + 1) == 0 || (i + 1) % current == 0)) {
                arrange[i] = current;
                count += countArr(N, arrange, current + 1);
                arrange[i] = 0;
            }
        }
        return count;
    }
}

class BeautifulArrangement {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 1;
        res[0] = 1;
        for (int i = k; i>= 1; i--, index++) {
            res[index] = res[index - 1] + (index % 2 == 1 ? i : -i);
        }
        for (int i = 1 + k + 1; i <= n; i++) res[index++] = i;
        return res;
    }
}

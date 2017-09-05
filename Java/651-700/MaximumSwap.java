class MaximumSwap {
    public int maximumSwap(int num) {
        return Integer.parseInt(new String(maximumSwap((num + "").toCharArray(), 0)));
    }
    public char[] maximumSwap(char[] cs, int k) {
        if (k >= cs.length) return cs;
        int max = -1;
        for (int i = k; i < cs.length; i++) {
            if (max == -1 || cs[i] >= cs[max]) {
                max = i;
            }
        }
        for (int i = k; i < max; i++) {
            if (cs[i] < cs[max]) {
                swap(cs, i, max);
                return cs;
            }
        }
        return maximumSwap(cs, max + 1);
    }
    void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}

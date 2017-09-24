class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int cnt = 1;
        for (int i : flowers) {
            Integer low = set.lower(i), high = set.higher(i);
            if (low != null && i - low == k + 1 ||
                high != null && high - i == k + 1) return cnt;
            set.add(i);
            cnt++;
        }
        return -1;
    }
}

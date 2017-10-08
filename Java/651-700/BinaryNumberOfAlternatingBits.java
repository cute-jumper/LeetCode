class BinaryNumberOfAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int mask = n & 3;
        if (mask == 0) return false;
        for (int i = n; i != 0; i >>= 1, mask = (~mask & 3)) {
            if ((i & 3) != mask) return false;
        }
        return true;
    }
}

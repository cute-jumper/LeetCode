class BinaryNumberOfAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        long v = (long)n + (n >> 1);
        return (v & (v + 1)) == 0;
    }
}

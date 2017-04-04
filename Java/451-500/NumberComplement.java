public class NumberComplement {
    public int findComplement(int num) {
        int mask = 0;
        int n = num;
        for (int i = 31; i >= 0; i--) {
            if ((n & (1 << 31)) == 0) mask |= 1 << i;
            else break;
            n <<= 1;
        }
        return ~num & ~mask;
    }
}

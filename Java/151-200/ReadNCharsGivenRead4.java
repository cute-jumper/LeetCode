/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharsGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] cache = new char[4];
        for (int i = 0; i < n;) {
            int size = read4(cache);
            if (size == 0) return i;
            for (int j = i; i < j + size && i < n; i++) buf[i] = cache[i-j];
        }
        return n;
    }
}

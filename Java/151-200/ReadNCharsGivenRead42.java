/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharsGivenRead42 extends Reader4 {
    int bufPos = -1;
    char[] cache = new char[4];
    int bufSize = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        for (int i = 0; i < n;) {
            if (bufPos >= 0) {
                buf[i++] = cache[bufPos++];
                if (bufPos == bufSize) bufPos = -1;
            } else {
                bufSize = read4(cache);
                if (bufSize == 0) return i;
                bufPos = 0;
            }
        }
        return n;
    }
}

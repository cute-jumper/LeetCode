public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return true;
        int index = 0;
        while (index < data.length) {
            int first = data[index];
            int length = numOfBytes(first);
            if (length == 1 || length > 4) return false;
            if (length > 0){
                if (index + length > data.length) return false;
                for (int i = index + 1; i < index + length; i++) {
                    if (!isLeadingOneZero(data[i])) return false;
                }
                index += length;
            } else {
                index++;
            }
        }
        return true;
    }
    public int numOfBytes(int word) {
        int mask = (1 << 7);
        int count = 0;
        while ((word & mask) != 0) {
            mask >>= 1;
            count++;
        }
        return count;
    }
    public boolean isLeadingOneZero(int word) {
        return (word & (1 << 7 | 1 << 6)) == (1 << 7);
    }
}

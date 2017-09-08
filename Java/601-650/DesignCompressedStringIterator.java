public class StringIterator {
    int index;
    int repeat;
    String str;
    char ch;
    public StringIterator(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if (!hasNext()) return ' ';
        if (repeat == 0) {
            ch = str.charAt(index);
            int count = 0;
            for (index++; index < str.length(); index++) {
                char c = str.charAt(index);
                if (c >= '0' && c <= '9') {
                    count *= 10;
                    count += c - '0';
                } else {
                    break;
                }
            }
            repeat = count;
        }
        repeat--;
        return ch;
    }

    public boolean hasNext() {
        return index < str.length() || repeat > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

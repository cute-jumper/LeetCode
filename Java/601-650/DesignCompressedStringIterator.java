public class StringIterator {
    int index;
    int curr;
    int repeat;
    String str;
    char ch;
    public StringIterator(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (curr == repeat) {
            ch = str.charAt(index);
            repeat = 0;
            for (index++; index < str.length(); index++) {
                char c = str.charAt(index);
                if (c >= '0' && c <= '9') {
                    count *= 10;
                    count += c - '0';
                } else {
                    break;
                }
            }
            curr = 1;
            return ch;
        } else {
            curr++;
            return ch;
        }
    }

    public boolean hasNext() {
        return index < str.length() || index == str.length() && curr < repeat;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

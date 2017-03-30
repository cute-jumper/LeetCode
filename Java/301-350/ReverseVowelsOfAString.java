public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int low = 0;
        int high = s.length() - 1;
        char[] chars = s.toCharArray();
        while (low < high) {
            while (low < high && !isVowel(chars[low])) low++;
            while (low < high && !isVowel(chars[high])) high--;
            if (low < high) {
                char c = chars[low];
                chars[low] = chars[high];
                chars[high] = c;
                low++;
                high--;
            }
        }
        return new String(chars);
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

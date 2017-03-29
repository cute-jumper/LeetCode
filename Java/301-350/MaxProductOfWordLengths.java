public class MaxProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] code = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                code[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        int maxProd = 0;
        for (int i = 0; i < code.length; i++) {
            for (int j = i + 1; j < code.length; j++) {
                if ((code[i] & code[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    if (prod > maxProd) maxProd = prod;
                }
            }
        }
        return maxProd;
    }
}
